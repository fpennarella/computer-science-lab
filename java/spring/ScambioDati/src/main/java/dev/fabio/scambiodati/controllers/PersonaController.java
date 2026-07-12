package dev.fabio.scambiodati.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.fabio.scambiodati.models.Persona;

@RestController
@RequestMapping("persona")
public class PersonaController {

	@GetMapping("dettaglio")
	public Persona restituisciPersona() {
		Persona persona1 = new Persona("Fabio", "Pennarella", 23);
		return persona1;
	}
	
	@GetMapping("elenco")
	public List <Persona> elencoPersone() {
		List<Persona> elenco = new ArrayList<Persona>();
		
		Persona persona1 = new Persona("Fabio", "Pennarella", 23);
		Persona persona2 = new Persona("Pasquale", "Pennarella", 52);
		Persona persona3 = new Persona("Valeria", "Pennarella", 20);
		
		elenco.add(persona1);
		elenco.add(persona2);
		elenco.add(persona3);
		
		return elenco;

	}
	
	@GetMapping("nuova")
	public Persona nuovaPersona(
			@RequestParam(name="nom") String nome,
			@RequestParam(name="cog") String cognome,
			@RequestParam(name="eta") int eta) {
		
		Persona persona1 = new Persona(nome, cognome, eta);
		
		return persona1;
		
	}
	
	@PostMapping("inserisci")
	public Persona inserisciPersona(@RequestBody Persona persona) {
		return persona;
	}
	
	
}
