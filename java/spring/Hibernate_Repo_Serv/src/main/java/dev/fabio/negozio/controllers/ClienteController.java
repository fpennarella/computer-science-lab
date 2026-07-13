package dev.fabio.negozio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fabio.negozio.models.ClienteDTO;
import dev.fabio.negozio.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("{valCodice}")
	public ResponseEntity<ClienteDTO> getByCodice(@PathVariable String valCodice) {
		
		ClienteDTO dto = service.getClienteByCodice(valCodice);
		
		if(dto != null) return ResponseEntity.ok(dto);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping
	public ResponseEntity<?> insertCliente(@RequestBody ClienteDTO dto) {
		if(dto.getCodice_identif().isEmpty() || dto.getCont_email().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		if(service.insertClientePersonalizz(dto) != null) {
			return ResponseEntity.ok(dto);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
 
	}
	
}
