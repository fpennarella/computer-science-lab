package dev.fabio.negozio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fabio.negozio.models.Cliente;
import dev.fabio.negozio.models.ClienteDTO;
import dev.fabio.negozio.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;

	public ClienteDTO getClienteByCodice(String codice) {
		Cliente cli = repo.findByCodi(codice);
		
		ClienteDTO dto = null;
		
		if(cli != null) {
			dto = new ClienteDTO();
			dto.setCodice_identif(codice);
			dto.setCont_email(cli.getEmail());
			dto.setCont_telefonico(cli.getTel());
			dto.setNominativo(cli.getNomi());
		}
		
		return dto;
	}
	
	public ClienteDTO insertClientePersonalizz(ClienteDTO dto) {
		Cliente cli = new Cliente();
		try {
			if(dto != null) {
				cli.setCodi(dto.getCodice_identif());
				cli.setEmail(dto.getCont_email());
				cli.setNomi(dto.getNominativo());
				cli.setTel(dto.getCont_telefonico());
				
				repo.save(cli);
				
				return dto;
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return null;
	}
	
}
