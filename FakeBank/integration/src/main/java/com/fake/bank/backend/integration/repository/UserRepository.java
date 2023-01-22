package com.fake.bank.backend.integration.repository;

import com.fake.bank.backend.integration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByPersonalNumber(String personalNumber);

}
