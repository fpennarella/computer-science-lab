package dev.fabio.servicesdependencyinjection.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fabio.servicesdependencyinjection.models.Prodotto;
import dev.fabio.servicesdependencyinjection.services.ProdottoService;

@RestController
@RequestMapping("api/prodotti")
public class ProdottoController {
	
	@Autowired
	private ProdottoService service;
	
	@GetMapping("test")
	public String test() {
		return "Ciao";
	}

	@GetMapping()
	public List<Prodotto> listaProdotti() {
		return service.getAllProdotti();
	}
	
	@GetMapping("{id}")
	public Prodotto getProdottoById(@PathVariable int id) {
		return service.getProdottoById(id);
	}
	
	@PostMapping()
	public Prodotto insertProdotto(@RequestBody Prodotto prodotto) {
		return service.addProdotto(prodotto);
	}
}
