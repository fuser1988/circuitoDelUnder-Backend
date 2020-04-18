package ar.edu.unq.circuito.controller;

import java.util.Date;
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
@RequestMapping("/circuito_under")
public class RecitalController {

	@Autowired
	RecitalService recitalService;
	
	@PostMapping("/recitales")
	public void guaradr(@RequestBody Recital recital) {
		recital.setFecha(recital.getFecha());
		recitalService.guardar(recital);
	}
	@PostMapping("/recitales/fake")
	public void DataLoad() {
		recitalService.cargarDatos();
	}
	
	@GetMapping("/recitales")
	public List<Recital> buscar() {
		return recitalService.buscarTodos();
	}
	
	@GetMapping("/recitales/bandas")
	public List<Recital> filterGenero(@RequestParam(value = "genero") String genero) {
		return recitalService.filterGenero(genero);
	}
}
