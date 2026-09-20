#!/usr/bin/env bash
# Seeds multiple cities, venues, screens, seats, movies, shows and show seats via the REST API.
# Usage: scripts/seed-test-data.sh [base-url]   (default http://localhost:5000)
set -euo pipefail
BASE="${1:-http://localhost:5000}/api"

# post <path> <json> -> prints the created id
post() {
  curl -sf -X POST "$BASE/$1" -H 'Content-Type: application/json' -d "$2" \
    | sed -E 's/.*"id":([0-9]+).*/\1/'
}

echo "Creating actors and movies..."
declare -a MOVIES=()
add_movie() { # name actor desc rating duration
  local a; a=$(post actors "{\"name\":\"$2\",\"description\":\"Test actor\"}")
  MOVIES+=("$(post movies "{\"name\":\"$1\",\"description\":\"$3\",\"rating\":$4,\"duration\":$5,\"actor\":{\"id\":$a},\"banner\":\"https://placehold.co/300x450?text=${1// /+}\"}")")
}
add_movie "Jawan"          "Shah Rukh Khan"  "A man driven to right wrongs."   4 169
add_movie "Animal"         "Ranbir Kapoor"   "A father-son crime drama."       3 201
add_movie "Dunki"          "Shah Rukh Khan"  "Friends chase a dream abroad."   4 161
add_movie "Tiger 3"        "Salman Khan"     "A spy thriller."                 3 156
add_movie "RRR"            "Ram Charan"      "Two revolutionaries, one cause." 5 182
add_movie "Fighter"        "Hrithik Roshan"  "Air force action."               4 166

CITIES=("Mumbai|Maharashtra" "Delhi|Delhi" "Bengaluru|Karnataka" "Hyderabad|Telangana")
VENUES=("PVR Phoenix|High Street" "INOX Central|MG Road")
TIMES=("10:00:00|12:45:00" "18:00:00|20:45:00")
TODAY=$(date +%F)
n=0

for c in "${CITIES[@]}"; do
  city=$(post cities "{\"name\":\"${c%%|*}\",\"state\":\"${c##*|}\",\"country\":\"India\"}")
  echo "City ${c%%|*} (id $city)"
  for v in "${VENUES[@]}"; do
    venue=$(post venues "{\"venueName\":\"${v%%|*}\",\"address\":\"${v##*|}, ${c%%|*}\",\"city\":{\"id\":$city}}")
    screen=$(post screens "{\"name\":\"Screen 1\",\"eventVenue\":{\"id\":$venue}}")
    seats=()
    for row in 1 2 3 4; do
      type=REGULAR; [ "$row" -eq 3 ] && type=GOLD; [ "$row" -eq 4 ] && type=PREMIUM
      for col in 1 2 3 4 5; do
        seats+=("$(post seats "{\"screen\":{\"id\":$screen},\"row\":$row,\"col\":$col,\"type\":\"$type\"}"):$type")
      done
    done
    for t in "${TIMES[@]}"; do
      movie=${MOVIES[$((n % ${#MOVIES[@]}))]}; n=$((n + 1))
      show=$(post movie-shows "{\"movie\":{\"id\":$movie},\"screen\":{\"id\":$screen},\"startTime\":\"${t%%|*}\",\"endTime\":\"${t##*|}\",\"startDate\":\"$TODAY\"}")
      for s in "${seats[@]}"; do
        case "${s##*:}" in REGULAR) tier=REGULAR; price=200;; GOLD) tier=WEEKEND; price=350;; *) tier=PREMIUM; price=500;; esac
        post show-seats "{\"movieShow\":{\"id\":$show},\"seat\":{\"id\":${s%%:*}},\"priceTier\":\"$tier\",\"price\":$price,\"status\":\"AVAILABLE\"}" >/dev/null
      done
    done
    echo "  Venue ${v%%|*} (id $venue): screen $screen, 20 seats, ${#TIMES[@]} shows"
  done
done
echo "Done."
