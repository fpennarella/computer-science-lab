package dev.fabio.store.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="foods")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, updatable = false)
	private String uuid;
	
	@Column(name = "food_name", nullable = false)
	private String name;
	
	private String category;
	
	private Integer calories;
	
	private BigDecimal price;
	
	private boolean available;
	
	private LocalDate expirationDate;
	
	private LocalDateTime createdAt;
	
}
