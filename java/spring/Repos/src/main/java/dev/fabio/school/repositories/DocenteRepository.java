package dev.fabio.school.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import dev.fabio.school.models.Docente;

@Repository
public class DocenteRepository implements IRepositoryRead<Docente> {

	@Override
	public Docente getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
