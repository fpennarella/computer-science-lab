package dev.fabio.school.repositories;

public interface IRepositoryWrite<T> {

	boolean Insert(T obj);
	boolean Update(T obj);
	boolean Delete(int id);
	
}
