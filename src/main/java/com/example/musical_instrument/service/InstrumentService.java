package com.example.musical_instrument.service;

import com.example.musical_instrument.entity.Instrument;
import com.example.musical_instrument.pojo.InstrumentPojo;

import java.util.List;

public interface InstrumentService {
    List<Instrument> findAll();
    Instrument saveData(InstrumentPojo instrumentPojo);
    Instrument updateData(Integer id, InstrumentPojo instrumentPojo);
    void deleteData(Integer id);
    Instrument findById(Integer id);
}
