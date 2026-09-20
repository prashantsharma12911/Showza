package com.Showza.swz.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Showza.swz.movie.model.ShowSeat;
import com.Showza.swz.movie.model.ShowSeatStatus;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Modifying
    @Query("UPDATE ShowSeat s SET s.status = :to WHERE s.id = :id AND s.status = :from")
    int updateStatus(@Param("id") Long id, @Param("from") ShowSeatStatus from, @Param("to") ShowSeatStatus to);
}
