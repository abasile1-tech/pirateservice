package com.example.pirateservice.controllers;

import com.example.pirateservice.models.Pirate;
import com.example.pirateservice.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PirateController {
    @Autowired
    PirateRepository pirateRepository;

    @GetMapping(value = "/pirates")
    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }
}
