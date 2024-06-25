package com.example.musical_instrument.repository;

import com.example.musical_instrument.entity.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

}
