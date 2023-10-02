package com.example.pirateservice;

import com.example.pirateservice.models.Pirate;
import com.example.pirateservice.models.Ship;
import com.example.pirateservice.repositories.PirateRepository;
import com.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class PirateserviceApplicationTests {

	// Dependency Injection via Autowired
	@Autowired
	PirateRepository pirateRepository;
	@Autowired
	ShipRepository shipRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void createShipAndAddPirate() {
		Ship ship = new Ship("Boaty McBoat");
		Pirate pirate = new Pirate("Jack", "Sparrow", 32, ship);
		shipRepository.save(ship);
		pirateRepository.save(pirate);

		ArrayList<Pirate> listOfPirates = new ArrayList<>();
		listOfPirates.add(pirate);

		ship.setPirates(listOfPirates);

		System.out.println(ship.getPirates());
	}


}

