package dev.fabio.store.services;

import java.util.List;

import dev.fabio.store.models.FoodDTO;

public interface FoodService {

	FoodDTO create (FoodDTO dto);
	
	List<FoodDTO> findAll();
	
	FoodDTO findByUuid(String uuid);
	
	FoodDTO update(String uuid, FoodDTO dto);
	
	void delete(String uuid);
	
	List<FoodDTO> findByCategory(String category);
	
}
