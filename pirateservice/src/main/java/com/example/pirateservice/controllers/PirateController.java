package com.example.pirateservice.controllers;

import com.example.pirateservice.models.Pirate;
import com.example.pirateservice.repositories.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {
    @Autowired
    PirateRepository pirateRepository;

    @GetMapping(value = "/pirates")
    public List<Pirate> getAllPirates() {
        return pirateRepository.findAll();
    }

    @GetMapping(value = "/pirates/{id}")
    public Optional<Pirate> getPirate(@PathVariable Long id) {
        return pirateRepository.findById(id);
    }

    @PostMapping(value = "/pirates")
    public Pirate createPirate(@RequestBody Pirate pirate) {
        return pirateRepository.save(pirate);
    }

    @DeleteMapping(value = "/pirates/{id}")
    public void deletePirate(@PathVariable Long id) {
        pirateRepository.deleteById(id);
    }

    @PutMapping(value = "/pirates/{id}")
    public Pirate replacePirate(@PathVariable Long id, @RequestBody Pirate newPirate) {
        return pirateRepository.findById(id).map((pirate) -> {
            pirate.setAge(newPirate.getAge());
            pirate.setFirstName(newPirate.getFirstName());
            pirate.setLastName(newPirate.getLastName());
            return pirateRepository.save(pirate);
        }).orElseGet(() -> {
            newPirate.setId(id);
            return pirateRepository.save(newPirate);
        });
    }
}
