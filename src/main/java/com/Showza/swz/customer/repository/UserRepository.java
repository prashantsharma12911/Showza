package com.Showza.swz.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.customer.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
