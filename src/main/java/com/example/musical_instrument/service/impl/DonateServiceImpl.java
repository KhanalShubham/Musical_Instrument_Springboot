package com.example.musical_instrument.service.impl;

import com.example.musical_instrument.entity.Donate;
import com.example.musical_instrument.entity.Instrument;
import com.example.musical_instrument.entity.User;
import com.example.musical_instrument.pojo.DonatePojo;
import com.example.musical_instrument.repository.DonateRepository;
import com.example.musical_instrument.repository.InstrumentRepository;
import com.example.musical_instrument.repository.UserRepository;
import com.example.musical_instrument.service.DonateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonateServiceImpl implements DonateService {

    private final DonateRepository donateRepository;
    private final InstrumentRepository instrumentRepository;
    private final UserRepository userRepository;

    @Override
    public List<Donate> findAll() {
        return donateRepository.findAll();
    }

    @Override
    public Donate saveData(DonatePojo donatePojo) {
        Donate donate = new Donate();
        Instrument instrument = instrumentRepository.findById(donatePojo.getInstrument_id())
                .orElseThrow(() -> new IllegalArgumentException("Instrument not found"));
        User user = userRepository.findById(donatePojo.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        donate.setInstrument(instrument);
        donate.setUser(user);

        return donateRepository.save(donate);
    }

    @Override
    public Donate updateData(Integer id, DonatePojo donatePojo) {
        Donate donate = donateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Donation not found"));

        Instrument instrument = instrumentRepository.findById(donatePojo.getInstrument_id())
                .orElseThrow(() -> new IllegalArgumentException("Instrument not found"));
        User user = userRepository.findById(donatePojo.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        donate.setInstrument(instrument);
        donate.setUser(user);

        return donateRepository.save(donate);
    }

    @Override
    public void deleteData(Integer id) {
        Donate donate = donateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Donation not found"));
        donateRepository.delete(donate);
    }

    @Override
    public Donate findById(Integer id) {
        return donateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Donation not found"));
    }
}
