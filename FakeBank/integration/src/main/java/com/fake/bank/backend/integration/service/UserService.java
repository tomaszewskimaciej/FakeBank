package com.fake.bank.backend.integration.service;

import com.fake.bank.backend.integration.entity.User;
import com.fake.bank.backend.integration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findUserByPersonalNumber(String personalNumber) {
        return repository.findByPersonalNumber(personalNumber).get(0);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return repository.findById(id);
    }

    public void saveOrUpdate(User user) {
        repository.save(user);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
