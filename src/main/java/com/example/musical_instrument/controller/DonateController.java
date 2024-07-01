package com.example.musical_instrument.controller;

import com.example.musical_instrument.entity.Donate;
import com.example.musical_instrument.pojo.DonatePojo;
import com.example.musical_instrument.service.DonateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donations")
public class DonateController {

    @Autowired
    private DonateService donateService;

    @GetMapping
    public ResponseEntity<List<Donate>> findAll() {
        List<Donate> donations = donateService.findAll();
        return ResponseEntity.ok(donations);
    }

    @PostMapping
    public ResponseEntity<Donate> save(@RequestBody DonatePojo donatePojo) {
        Donate savedDonate = donateService.saveData(donatePojo);
        return ResponseEntity.ok(savedDonate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donate> update(@PathVariable Integer id, @RequestBody DonatePojo donatePojo) {
        Donate updatedDonate = donateService.updateData(id, donatePojo);
        if (updatedDonate != null) {
            return ResponseEntity.ok(updatedDonate);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        donateService.deleteData(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donate> getById(@PathVariable Integer id) {
        Donate donate = donateService.findById(id);
        if (donate != null) {
            return ResponseEntity.ok(donate);
        }
        return ResponseEntity.notFound().build();
    }
}
