package com.example.musical_instrument.service;

import com.example.musical_instrument.entity.Donate;
import com.example.musical_instrument.pojo.DonatePojo;

import java.util.List;

public interface DonateService {
    List<Donate> findAll();
    Donate saveData(DonatePojo donatePojo);
    Donate updateData(Integer id, DonatePojo donatePojo);
    void deleteData(Integer id);
    Donate findById(Integer id);
}
