package com.example.pirateservice.controllers;

import com.example.pirateservice.models.Raid;
import com.example.pirateservice.repositories.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RaidController {
    @Autowired
    RaidRepository raidRepository;

    @GetMapping(value = "/raids")
    public ResponseEntity<List<Raid>> getAllRaids () {
        return new ResponseEntity<>(raidRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/raids/{id}")
    public ResponseEntity<Optional<Raid>> getRaid(@PathVariable Long id) {
        return new ResponseEntity<>(raidRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/raids")
    public Raid createRaid(@RequestBody Raid raid) {
        return raidRepository.save(raid);
    }

    @DeleteMapping(value = "/raids/{id}")
    public void deleteRaid(@PathVariable Long id) {
        raidRepository.deleteById(id);
    }

    @PutMapping(value = "/raids/{id}")
    public Raid replaceRaid(@PathVariable Long id, @RequestBody Raid newRaid) {
        return raidRepository.findById(id).map((raid) -> {
            raid.setLocation(newRaid.getLocation());
            raid.setLoot(newRaid.getLoot());
            return raidRepository.save(raid);
        }).orElseGet(() -> {
            newRaid.setId(id);
            return raidRepository.save(newRaid);
        });
    }
}

