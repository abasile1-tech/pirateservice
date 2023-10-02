package com.example.pirateservice.controllers;

import com.example.pirateservice.models.Ship;
import com.example.pirateservice.repositories.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShipController {
    @Autowired
    ShipRepository shipRepository;
    
    @GetMapping(value = "/ships")
    public ResponseEntity<List<Ship>> getAllShips () {
        return new ResponseEntity<>(shipRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/ships/{id}")
    public ResponseEntity<Optional<Ship>> getShip(@PathVariable Long id) {
        return new ResponseEntity<>(shipRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/ships")
    public Ship createShip(@RequestBody Ship ship) {
        return shipRepository.save(ship);
    }

    @DeleteMapping(value = "/ships/{id}")
    public void deleteShip(@PathVariable Long id) {
        shipRepository.deleteById(id);
    }

    @PutMapping(value = "/ships/{id}")
    public Ship replaceShip(@PathVariable Long id, @RequestBody Ship newShip) {
        return shipRepository.findById(id).map((ship) -> {
            ship.setName(newShip.getName());
            return shipRepository.save(ship);
        }).orElseGet(() -> {
            newShip.setId(id);
            return shipRepository.save(newShip);
        });
    }
}
