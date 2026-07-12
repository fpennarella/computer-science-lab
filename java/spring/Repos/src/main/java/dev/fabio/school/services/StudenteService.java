package dev.fabio.school.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fabio.school.models.Studente;
import dev.fabio.school.repositories.StudenteRepository;

@Service
public class StudenteService {
	
	@Autowired
	private StudenteRepository repo;

	public List<Studente> listaStudentiService() {
		return repo.getAll();
	}
	
	public Studente studDetails(int id) {
		return repo.getById(id);
	}
	
	public boolean studInsertService(Studente studente) {
		return repo.Insert(studente);
	}
	
	public boolean StudDeleteService(int id) {
		return repo.Delete(id);
	}
	
	public boolean studUpdateService(Studente studente) {
		return repo.Update(studente);
	}
}
