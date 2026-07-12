package dev.fabio.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fabio.school.models.Studente;
import dev.fabio.school.services.StudenteService;

@RestController
@RequestMapping("api/studenti")
public class StudenteController {
	
	@Autowired
	private StudenteService service;
	
	@GetMapping
	public List<Studente> listaStudenti() {
		return service.listaStudentiService();
	}
	
	@GetMapping("{id}")
	public ResponseEntity studDetails(@PathVariable int id) {
		Studente studente = service.studDetails(id);
		
		if (studente == null) return ResponseEntity.notFound().build();
		else return ResponseEntity.ok(studente);
	}
	
	 @PostMapping
	 public ResponseEntity studInsert(@RequestBody Studente studente) {
		 boolean insertResult = service.studInsertService(studente);
		 
		 if(insertResult == true) return ResponseEntity.ok().build();
		 else return ResponseEntity.unprocessableEntity().build();
	 }
	 
	 @DeleteMapping("{id}")
	 public ResponseEntity studDelete(@PathVariable int id) {
		 if (service.StudDeleteService(id)) return ResponseEntity.ok().build();
		 else return ResponseEntity.badRequest().build();
	 }
	 
	 @PutMapping("{id}")
	 public ResponseEntity studUpdate(@PathVariable int id, @RequestBody Studente studente) {
		 if(id != 0) {
			 studente.setId(id);
			 
			 if(service.studUpdateService(studente)) return ResponseEntity.ok(studente);
		 }
		 
		 return ResponseEntity.badRequest().build();
	 }
	
}
