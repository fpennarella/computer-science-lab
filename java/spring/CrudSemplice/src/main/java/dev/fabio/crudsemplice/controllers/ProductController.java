package dev.fabio.crudsemplice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fabio.crudsemplice.models.Prodotto;

@RestController
@RequestMapping("api/prodotti")
public class ProductController {
	
	private List<Prodotto> prodotti = new ArrayList<Prodotto>() {{
		add(new Prodotto(1, "Matita", "12345", 0.25f));
		add(new Prodotto(2, "Gomma", "abc123", 0.30f));
	}};
	
	@GetMapping()
	public List<Prodotto> listaProdotti() {
		return prodotti;
	}
	
	@GetMapping("{id}")
	public Prodotto getProdottoById(@PathVariable int id) {
		for(int i = 0; i < prodotti.size(); i++) {
			if(prodotti.get(i).getId() == id) {
				return prodotti.get(i);
			}
		}
		
		return null;
	}
	
	@PostMapping()
	public Prodotto InsertProdotto(@RequestBody Prodotto prodotto) {
		prodotto.setId(prodotti.size() + 1);
		prodotti.add(prodotto);
		
		return prodotto;
	}
	
}
