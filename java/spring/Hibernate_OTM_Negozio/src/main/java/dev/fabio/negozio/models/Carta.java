package dev.fabio.negozio.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Carta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartaID")
	public Integer id;
	
	@Column(name="codice")
	public String codi;
	
	@Column(name="negozio")
	public String nego;
	
	@ManyToOne
	@JoinColumn(name="personaRIF")
	private Cliente persona;
}
