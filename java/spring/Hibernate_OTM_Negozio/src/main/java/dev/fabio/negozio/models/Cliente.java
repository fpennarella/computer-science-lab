package dev.fabio.negozio.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="personaID")
	private Integer id;
	
	@Column(name="nominativo")
	private String nomi;
	
	@Column(name="telefono")
	private String tel;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="persona",
			cascade = CascadeType.REMOVE,
			fetch = FetchType.EAGER)
	private List<Carta> elencoCarte;
	
}
