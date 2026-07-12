package dev.fabio.school.models;

import java.sql.Date;

public class Studente extends Persona {
	private String matricola;
	private Date dataDiNascita;

	public Studente() {
		super();
	}

	public Studente(String nome, String cognome, String matricola, Date dataDiNascita) {
		super(nome, cognome);
		this.matricola = matricola;
		this.dataDiNascita = dataDiNascita;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", dataDiNascita=" + dataDiNascita + ", nome=" + nome + ", cognome="
				+ cognome + "]";
	}
	
}
