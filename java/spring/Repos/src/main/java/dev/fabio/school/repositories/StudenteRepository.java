package dev.fabio.school.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysql.cj.jdbc.MysqlDataSource;

import dev.fabio.school.models.Studente;

@Repository
public class StudenteRepository implements IRepositoryRead<Studente>, IRepositoryWrite<Studente> {

	@Override
	public Studente getById(int id) {
		Studente studente = null;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "SELECT idStudente, nome, cognome, matricola, dataDiNascita FROM Studenti "
					+ "WHERE idStudente = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				studente = new Studente();
				studente.setId(rs.getInt("idStudente"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setMatricola(rs.getString("matricola"));
				studente.setDataDiNascita(rs.getDate("dataDiNascita"));
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return studente;
	}

	@Override
	public List<Studente> getAll() {
		
		List<Studente> list = new ArrayList<Studente>();
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "SELECT idStudente, nome, cognome, matricola, dataDiNascita FROM Studenti";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Studente studente = new Studente();
				studente.setId(rs.getInt("idStudente"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setMatricola(rs.getString("matricola"));
				studente.setDataDiNascita(rs.getDate("dataDiNascita"));
				
				list.add(studente);
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return list;
	}
	
	public Studente getByMatricola(String matricola) {
		// TODO
		return null;
	}
	
	@Override
	public boolean Insert(Studente obj) {
		boolean result = false;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "INSERT INTO Studenti (nome, cognome, matricola, dataDiNascita) "
					+ "VALUES (?, ?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getCognome());
			ps.setString(3, obj.getMatricola());
			ps.setDate(4, obj.getDataDiNascita());

			int affectedRows = ps.executeUpdate();
			
			if(affectedRows > 0) result = true;
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	@Override
	public boolean Update(Studente obj) {
		boolean result = false;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			int id = obj.getId();
			Studente studente = this.getById(id);
			
			if(studente != null) {
				studente.setNome(obj.getNome() == null ? studente.getNome() : obj.getNome());
				studente.setCognome(obj.getCognome() == null ? studente.getCognome() : obj.getCognome());
				studente.setMatricola(obj.getMatricola() == null ? studente.getMatricola() : obj.getMatricola());
				studente.setDataDiNascita(obj.getDataDiNascita() == null ? studente.getDataDiNascita() : obj.getDataDiNascita());
				
				String query = "UPDATE Studenti SET "
				        + "nome = ?, "
				        + "cognome = ?, "
				        + "matricola = ?, "
				        + "dataDiNascita = ? "
				        + "WHERE idStudente = ?";
				
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, studente.getNome());
				ps.setString(2, studente.getCognome());
				ps.setString(3, studente.getMatricola());
				ps.setDate(4, studente.getDataDiNascita());
				ps.setInt(5, studente.getId());
				
				int affectedRows = ps.executeUpdate();
				
				if (affectedRows > 0) result = true;
			}
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	@Override
	public boolean Delete(int id) {
		boolean result = false;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "DELETE FROM Studenti WHERE idStudente = ?;";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			int affectedRows = ps.executeUpdate();
			
			if(affectedRows > 0) result = true;
			
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	

}
