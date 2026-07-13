package dev.fabio.negozio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fabio.negozio.models.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer> {
	
	
}
