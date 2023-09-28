package com.example.pirateservice;

import com.example.pirateservice.models.Pirate;
import com.example.pirateservice.repositories.PirateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PirateserviceApplicationTests {

	// Dependency Injection via Autowired
	@Autowired
	PirateRepository pirateRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPirate() {
		Pirate jack = new Pirate("Jack", "Sparrow", 32);
		pirateRepository.save(jack);
	}


}

