package com.Showza.swz.booking.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

@Service
public class SeatLockServiceImpl implements SeatLockService {

    private static final String KEY_PREFIX = "showseat:lock:";

    private static final DefaultRedisScript<Long> RELEASE_SCRIPT = new DefaultRedisScript<>(
            "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end",
            Long.class);

    private final StringRedisTemplate redisTemplate;
    private final Duration ttl;

    public SeatLockServiceImpl(StringRedisTemplate redisTemplate,
            @Value("${booking.seat-lock.ttl:PT5M}") Duration ttl) {
        this.redisTemplate = redisTemplate;
        this.ttl = ttl;
    }

    private String key(Long showSeatId) {
        return KEY_PREFIX + showSeatId;
    }

    @Override
    public boolean tryLock(Long showSeatId, Long userId) {
        return Boolean.TRUE.equals(
                redisTemplate.opsForValue().setIfAbsent(key(showSeatId), String.valueOf(userId), ttl));
    }

    @Override
    public boolean isLockedBy(Long showSeatId, Long userId) {
        return String.valueOf(userId).equals(redisTemplate.opsForValue().get(key(showSeatId)));
    }

    @Override
    public boolean isLocked(Long showSeatId) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key(showSeatId)));
    }

    @Override
    public void release(Long showSeatId, Long userId) {
        redisTemplate.execute(RELEASE_SCRIPT, List.of(key(showSeatId)), String.valueOf(userId));
    }
}
