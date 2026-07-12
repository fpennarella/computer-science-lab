package dev.fabio.uni.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fabio.uni.models.Student;
import dev.fabio.uni.repositories.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentRepository repo;
	
	@GetMapping
	public List<Student> getAll() {					
		return repo.findAll();
	}
	
	@GetMapping("/{id}")
	public Student getById(@PathVariable int id) {
		return repo.findById((long) id).orElse(null);
	}
	
	@PostMapping
	public Student save(@RequestBody Student studente) {
		return repo.save(studente);
	}
	
	@GetMapping("/lastname/{last}")
	public List<Student> getByLastName(@PathVariable String last) {
		return repo.findByLast(last);
	}
	
	@GetMapping("/enrollmentid/{enroll}")
	public Student getByEnrollmentId(@PathVariable String enroll) {
		return repo.findByEnroll(enroll);
	}
	
	@GetMapping("combined/{first}/{last}") 
	public List<Student> getByFirstAndLast(@PathVariable String first, @PathVariable String last){
		return repo.findByFirstAndLast(first, last);
	}
	
	@GetMapping("/fragmentlast/{last}")
	public List<Student> getByLastFragment(@PathVariable String last) {
		return repo.findByLastFragment(last);
	}
	
}
