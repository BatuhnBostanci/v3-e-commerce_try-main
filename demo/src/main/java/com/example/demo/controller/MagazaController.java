package com.example.demo.controller;

import com.example.demo.entitiy.Magaza;
import com.example.demo.repository.MagazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magazas")
public class MagazaController {

    @Autowired
    private MagazaRepository magazaRepository;

    @GetMapping
    public ResponseEntity<List<Magaza>> getAllMagazas() {
        try {
            List<Magaza> magazas = magazaRepository.findAll();
            return ResponseEntity.ok(magazas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Magaza> saveMagaza(@RequestBody Magaza magaza) {
        try {
            Magaza savedMagaza = magazaRepository.save(magaza);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMagaza);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

