package dev.fabio.store.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fabio.store.models.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

	Optional<Food> findByUuid(String uuid);
	
	void deleteByUuid(String uuid);
	
	boolean existsByUuid(String uuid);
	
}
