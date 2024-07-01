package com.example.musical_instrument.controller;

import com.example.musical_instrument.entity.Instrument;
import com.example.musical_instrument.pojo.InstrumentPojo;
import com.example.musical_instrument.service.InstrumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instruments")
@RequiredArgsConstructor
public class InstrumentController {

    private final InstrumentService instrumentService;

    @GetMapping
    public ResponseEntity<List<Instrument>> findAll() {
        List<Instrument> instruments = instrumentService.findAll();
        return ResponseEntity.ok(instruments);
    }

    @PostMapping
    public ResponseEntity<Instrument> save(@RequestBody InstrumentPojo instrumentPojo) {
        Instrument savedInstrument = instrumentService.saveData(instrumentPojo);
        return ResponseEntity.ok(savedInstrument);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrument> update(@PathVariable Integer id, @RequestBody InstrumentPojo instrumentPojo) {
        Instrument updatedInstrument = instrumentService.updateData(id, instrumentPojo);
        if (updatedInstrument != null) {
            return ResponseEntity.ok(updatedInstrument);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        instrumentService.deleteData(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrument> getById(@PathVariable Integer id) {
        Instrument instrument = instrumentService.findById(id);
        if (instrument != null) {
            return ResponseEntity.ok(instrument);
        }
        return ResponseEntity.notFound().build();
    }
}
