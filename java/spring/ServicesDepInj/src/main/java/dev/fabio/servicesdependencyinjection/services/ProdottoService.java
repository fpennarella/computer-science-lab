package dev.fabio.servicesdependencyinjection.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.fabio.servicesdependencyinjection.models.Prodotto;

@Service
public class ProdottoService {

	private List<Prodotto> prodotti = new ArrayList<Prodotto>() {{
		add(new Prodotto(1, "Matita", "12345", 0.25f));
		add(new Prodotto(2, "Gomma", "abc123", 0.30f));
	}};
	
	//Restituisce tutti i prodotti (getAll)
	public List<Prodotto> getAllProdotti() {
		return prodotti;
	}
	
	//Restituisce un singolo prodotto (get ... ById)
	public Prodotto getProdottoById(int id) {
		return prodotti
				.stream()
				.filter(p -> p.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
	//Inserisci il prodotto (add...)
	public Prodotto addProdotto(Prodotto prodotto) {
		prodotto.setId(prodotti.size() + 1);
		
		prodotti.add(prodotto);
		
		return prodotto;
	}
}
