package com.Showza.swz.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.customer.model.User;
import com.Showza.swz.customer.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User user) {
        User existing = getById(id);
        user.setId(existing.getId());
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(getById(id));
    }
}
