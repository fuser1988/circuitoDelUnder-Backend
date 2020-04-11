package ar.edu.unq.circuito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.service.RecitalService;

@RestController
@RequestMapping("/api")
public class CircutioController {
	
	@Autowired
	RecitalService service;
	
	@PostMapping("/save")
	public void save(@RequestBody Recital recital) {
		service.guardar(recital);
	}

}
