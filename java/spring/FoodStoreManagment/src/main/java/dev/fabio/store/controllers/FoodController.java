package dev.fabio.store.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping
	public List<FoodDTO> findAll() {
		return foodService.findAll();
	}
	
	@GetMapping("/{uuid}")
	public FoodDTO findByUuid(@PathVariable("uuid") String uuid) {
		return foodService.findByUuid(uuid);
	}
	
	@PostMapping
	public void create(@RequestBody FoodDTO dto) {
		foodService.create(dto);
	}
	
}
