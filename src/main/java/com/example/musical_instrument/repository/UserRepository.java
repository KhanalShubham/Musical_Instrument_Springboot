package com.example.musical_instrument.repository;

import com.example.musical_instrument.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
