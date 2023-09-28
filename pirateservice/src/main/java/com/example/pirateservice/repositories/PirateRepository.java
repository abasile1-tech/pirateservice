package com.example.pirateservice.repositories;

import com.example.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long> {

}
