package com.example.pirateservice;

import com.example.pirateservice.models.Pirate;
import com.example.pirateservice.models.Raid;
import com.example.pirateservice.models.Ship;
import com.example.pirateservice.repositories.PirateRepository;
import com.example.pirateservice.repositories.RaidRepository;
import com.example.pirateservice.repositories.ShipRepository;
import org.junit.jupiter.api.BeforeEach;
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
	@Autowired
	RaidRepository raidRepository;

	@BeforeEach
	public void before () {
	}

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

	@Test
	public void addPiratesAndRaids(){
		Ship ship = new Ship("The Flying Dutchman");
		shipRepository.save(ship);

		Pirate pirate1 = new Pirate("Jack", "Sparrow", 32, ship);
		pirateRepository.save(pirate1);

		Raid raid1 = new Raid("Tortuga", 100);
		raidRepository.save(raid1);

		raid1.addPirate(pirate1);
		raidRepository.save(raid1);

	}


}

