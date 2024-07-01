package com.example.musical_instrument.repository;

import com.example.musical_instrument.entity.Donate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonateRepository extends JpaRepository<Donate, Integer> {
}
