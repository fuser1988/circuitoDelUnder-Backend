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

import ar.edu.unq.circuito.service.IniciativaRecitalService;
import ar.edu.unq.circuito.vo.IniciativaRecitalVo;

@RestController
@RequestMapping("/circuito_under")
public class IniciativaRecitalController {

    @Autowired
    IniciativaRecitalService iniciativaService;

    @CrossOrigin
    @PostMapping("/iniciativa_recitales")
    public void guardar(@RequestBody IniciativaRecitalVo iniciativa) {
        iniciativaService.guardar(iniciativa);
    }

    @CrossOrigin
    @GetMapping("/iniciativa_recitales")
    public Page<IniciativaRecitalVo> buscarTodos(Pageable pageable) {
        return iniciativaService.buscarTodos(pageable);
    }
}
