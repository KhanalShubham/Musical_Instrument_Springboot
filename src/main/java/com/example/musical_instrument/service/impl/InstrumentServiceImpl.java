package com.example.musical_instrument.service.impl;

import com.example.musical_instrument.entity.Instrument;
import com.example.musical_instrument.entity.Category;
import com.example.musical_instrument.entity.User;
import com.example.musical_instrument.pojo.InstrumentPojo;
import com.example.musical_instrument.repository.InstrumentRepository;
import com.example.musical_instrument.repository.CategoryRepository;
import com.example.musical_instrument.repository.UserRepository;
import com.example.musical_instrument.service.InstrumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstrumentServiceImpl implements InstrumentService {

    private final InstrumentRepository instrumentRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public List<Instrument> findAll() {
        return instrumentRepository.findAll();
    }

    @Override
    public Instrument saveData(InstrumentPojo instrumentPojo) {
        Category category = categoryRepository.findById(instrumentPojo.getCategory_id())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        User user = userRepository.findById(instrumentPojo.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Instrument instrument = new Instrument();
        instrument.setInstrument_name(instrumentPojo.getInstrument_name());
        instrument.setInstrument_price(instrumentPojo.getInstrument_price());
        instrument.setCategory(category);
        instrument.setUser(user);

        return instrumentRepository.save(instrument);
    }

    @Override
    public Instrument updateData(Integer id, InstrumentPojo instrumentPojo) {
        Instrument instrument = instrumentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Instrument not found"));

        Category category = categoryRepository.findById(instrumentPojo.getCategory_id())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        User user = userRepository.findById(instrumentPojo.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        instrument.setInstrument_name(instrumentPojo.getInstrument_name());
        instrument.setInstrument_price(instrumentPojo.getInstrument_price());
        instrument.setCategory(category);
        instrument.setUser(user);

        return instrumentRepository.save(instrument);
    }

    @Override
    public void deleteData(Integer id) {
        Instrument instrument = instrumentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Instrument not found"));
        instrumentRepository.delete(instrument);
    }

    @Override
    public Instrument findById(Integer id) {
        return instrumentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Instrument not found"));
    }
}
