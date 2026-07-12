package dev.fabio.negozio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fabio.negozio.models.Carta;
import dev.fabio.negozio.repositories.CartaRepository;

@RestController
@RequestMapping("/api")
public class CartaController {

	@Autowired
	private CartaRepository repo;
	
	@GetMapping("/carta/{id}")
	public Carta getById(@PathVariable Integer id) {
		return repo.findById(id).orElse(null);
	}
	
}
