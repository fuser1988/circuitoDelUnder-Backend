package ar.edu.unq.circuito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.circuito.model.IniciativaRecital;
import ar.edu.unq.circuito.service.IniciativaRecitalService;

@RestController
@RequestMapping("/circuito_under")
public class IniciativaRecitalController {

	@Autowired
	IniciativaRecitalService iniciativaService;
	
	@CrossOrigin
    @PostMapping("/iniciatica_recitales")
    public void guardar(@RequestBody IniciativaRecital iniciativa) {
        iniciativaService.guardar(iniciativa);
    }
	
	@CrossOrigin
    @GetMapping("/iniciatica_recitales")
	public Page<IniciativaRecital> buscarTodos(Pageable pageable) {
        return iniciativaService.buscarTodos(pageable);
    }
}
