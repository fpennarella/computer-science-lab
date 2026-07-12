package dev.fabio.negozio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fabio.negozio.models.Carta;

public interface CartaRepository extends JpaRepository<Carta, Integer> {
	
	

}
