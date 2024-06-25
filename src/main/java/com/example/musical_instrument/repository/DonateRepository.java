package com.example.musical_instrument.repository;

import com.example.musical_instrument.entity.Donate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateRepository extends JpaRepository<Donate, Integer> {
}
