package dev.fabio.scambiodati.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

	@GetMapping("saluta")	// ../hello/saluta
	public String saluta() {
		return "Ciao a tutti!";
	}
	
	@GetMapping("numero")	// ../hello/numero
	public float dammiNumero() {
		return 17.5f;
	}
	
	@GetMapping("saluta/{varNome}")	// ../hello/saluta/Fabio -> Ciao, Fabio
	public String salutaPersona(@PathVariable String varNome) {
		return "Ciao, " + varNome;
	}
	
	@GetMapping("saluta/{varNome}/{varCognome}")	// ../hello/saluta/Fabio/Pennarella -> Ciao, Fabio Pennarella
	public String salutaPersonaCOmpleta(
			@PathVariable String varNome, 
			@PathVariable String varCognome) {
		return "Ciao, " + varNome + " " + varCognome;
	}
	
	@GetMapping("parametri")
	public String salutaParametri(
			@RequestParam(name="nom") String varNome, 
			@RequestParam(name="cog") String varCognome,
			@RequestParam (name="eta") int varEta) {
		return "Ciao, " + varNome + " " + varCognome + " di età: " + varEta;
	}
	
	@GetMapping("salutami")
	public String salutaGet() {
		return "Ciao sono la GET";
	}
	
	@PostMapping("salutami")
	public String salutaPost() {
		return "Ciao sono la POST";
	}
}
