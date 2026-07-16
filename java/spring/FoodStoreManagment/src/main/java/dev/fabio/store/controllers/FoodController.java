package dev.fabio.store.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.fabio.store.models.FoodDTO;
import dev.fabio.store.services.FoodService;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

	private final FoodService foodService;
	
	public FoodController(FoodService fs) {
		this.foodService = fs;
	}
	
	@GetMapping("/{uuid}")
	public FoodDTO getByUuid(@PathVariable("uuid") String uuid) {
		return foodService.findByUuid(uuid);
	}
	
	@GetMapping
	public ResponseEntity<List<FoodDTO>> getFoods(
			@RequestParam(name="category", required = false) String category) {
		
		if (category != null) {
			return ResponseEntity.ok(foodService.findByCategory(category));
		}
		
		return ResponseEntity.ok(foodService.findAll());
	}
	
	@PostMapping
	public void create(@RequestBody FoodDTO dto) {
		foodService.create(dto);
	}
	
}
