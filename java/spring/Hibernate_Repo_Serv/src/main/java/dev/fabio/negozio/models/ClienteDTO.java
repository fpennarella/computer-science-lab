package dev.fabio.negozio.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

	private String nominativo;
	private String cont_telefonico;
	private String cont_email;
	private String codice_identif;
	
}
