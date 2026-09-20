package com.Showza.swz.booking.service;

public interface SeatLockService {

    /** Atomically locks the seat for the user (SET NX with TTL). Returns false if already locked by anyone. */
    boolean tryLock(Long showSeatId, Long userId);

    boolean isLockedBy(Long showSeatId, Long userId);

    boolean isLocked(Long showSeatId);

    /** Releases the lock only if it is still held by the given user. */
    void release(Long showSeatId, Long userId);
}
