package com.example.demo.controller;

import com.example.demo.entitiy.Magaza;
import com.example.demo.repository.MagazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magazas")
public class MagazaController {

    @Autowired
    private MagazaRepository magazaRepository;

    @GetMapping
    public List<Magaza> getAllMagazas() {
        return magazaRepository.findAll();
    }

    @PostMapping
    public Magaza saveMagaza(@RequestBody Magaza magaza) {
        return magazaRepository.save(magaza);
    }
}

