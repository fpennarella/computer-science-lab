package dev.fabio.uni.models;

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
@Table(name="Students")
@Data					// Genera i getters, setters, toString, equals e hashcode
@NoArgsConstructor		// Costruttore senza argomenti (necessario per JPA)
@AllArgsConstructor		// Costruttore con tutti i parametri
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="studentID")
	private long id;
	
	@Column(name="firstName")
	private String first;
	
	@Column(name="lastName")
	private String last;
	
	@Column(name="enrollment")
	private String enroll;
	
	private String email;

}
