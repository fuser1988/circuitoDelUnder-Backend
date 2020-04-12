package ar.edu.unq.circuito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.service.RecitalService;

@RestController
@RequestMapping("/circuito_under")
public class CircutioController {
	
	@Autowired
	RecitalService service;
	
	@PostMapping("/save")
	public void save(@RequestBody Recital recital) {
		service.guardar(recital);
	}
	
	@GetMapping("/recitales")
	public List<Recital> get() {
		return service.get();
	}
	
	@GetMapping("/recitales/{genero}")
	public List<Recital> filterGenero(@PathVariable("genero") String genero) {
		return service.getGenero(genero);
	}

}
