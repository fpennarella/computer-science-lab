package dev.fabio.store.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {
	
	private String uuid;
	
	private String name;
	
	private String cate;
	
	private Integer calo;
	
	private BigDecimal pri;
	
	private boolean avai;
	
	private LocalDate expi;
	
	private LocalDateTime crea;
}
