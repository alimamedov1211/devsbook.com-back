package com.devsbook.devsbook.repository;

import com.devsbook.devsbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    User findByToken(String token);
    ArrayList<User> findAll();
}
