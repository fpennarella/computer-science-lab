package dev.fabio.negozio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fabio.negozio.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> { 
	
	Cliente findByCodi(String cod);
}
