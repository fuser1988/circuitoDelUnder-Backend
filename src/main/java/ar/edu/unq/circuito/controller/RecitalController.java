package ar.edu.unq.circuito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.service.RecitalService;


@RestController
@RequestMapping("/api")
public class RecitalController {

	@Autowired
	RecitalService service;
	
	@PostMapping("/recitales")
	public void save(@RequestBody Recital recital) {
		Recital r = new Recital();
	
		service.guardar(r);
	}
	
	@GetMapping("/recitales")
	public List<Recital> get() {
		return service.get();
	}
	/*
	@GetMapping("/recitales/bandas")
	public List<Recital> filterGenero(@RequestParam(value = "genero") String genero) {
		return service.filterGenero(genero);
	}*/
}
