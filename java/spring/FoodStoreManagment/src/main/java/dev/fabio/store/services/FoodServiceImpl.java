package dev.fabio.store.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import dev.fabio.store.models.Food;
import dev.fabio.store.models.FoodDTO;
import dev.fabio.store.repositories.FoodRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {
	
	private final FoodRepository foodRepository;
	
	private Food getFoodByUuid(String uuid) {
		Food food = foodRepository.findByUuid(uuid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Food non trovato"));
				
		return food;
	}
	
	public FoodServiceImpl(FoodRepository fr) {
		this.foodRepository = fr;
	}

	@Override
	public FoodDTO create(FoodDTO dto) {
		Food food = new Food();
		
		food.setUuid(UUID.randomUUID().toString());
		food.setCreatedAt(LocalDateTime.now());
		
		mapToEntity(dto, food);
		
		Food savedFood = foodRepository.save(food);
		
		return mapToDto(savedFood);
	}

	@Override
	public List<FoodDTO> findAll() {
		return foodRepository.findAll()
				.stream()
				.map(this::mapToDto)
				.toList();
	}

	@Override
	public FoodDTO findByUuid(String uuid) {
		return mapToDto(this.getFoodByUuid(uuid));
	}

	@Override
	public FoodDTO update(String uuid, FoodDTO dto) {
		return mapToDto(this.getFoodByUuid(uuid));
	}

	@Override
	public void delete(String uuid) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<FoodDTO> findByCategory(String category) {
		return foodRepository.findByCategory(category)
				.stream()
				.map(this::mapToDto)
				.toList();
	}
	
	// MAPPING
	
	private FoodDTO mapToDto(Food food) {
		FoodDTO dto = new FoodDTO();
		dto.setUuid(food.getUuid());
		dto.setName(food.getName());
		dto.setCate(food.getCategory());
		dto.setCalo(food.getCalories());
		dto.setPri(food.getPrice());
		dto.setAvai(food.isAvailable());
		dto.setExpi(food.getExpirationDate());
		dto.setCrea(food.getCreatedAt());
		
		return dto;
	}
	
	private Food mapToEntity(FoodDTO dto, Food food) {
		// UUID non devono essere toccati!!!
		food.setName(dto.getName());
		food.setCategory(dto.getCate());
		food.setCalories(dto.getCalo());
		food.setPrice(dto.getPri());
		food.setAvailable(dto.isAvai());
		food.setExpirationDate(dto.getExpi());
		// CreateAt non deve essere toccato!!!
		
		return food;
	}

}
