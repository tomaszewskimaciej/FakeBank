package com.fake.bank.backend.integration.service;

import com.fake.bank.backend.common.exception.FakeBankException;
import com.fake.bank.backend.common.exception.type.FakeBankErrorType;
import com.fake.bank.backend.integration.entity.User;
import com.fake.bank.backend.integration.repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
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
        return repository.findByPersonalNumber(personalNumber);
    }

    public void saveUser(User user) {
        try {
            repository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new FakeBankException(FakeBankErrorType.FB_002);
        }
    }

}
