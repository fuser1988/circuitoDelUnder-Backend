package ar.edu.unq.circuito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.service.RecitalService;
import ar.edu.unq.circuito.vo.RecitalVo;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/circuito_under")
public class RecitalController {

    @Autowired
    RecitalService recitalService;

    @CrossOrigin
    @PostMapping("/recitales")
    public Recital guardar(@RequestBody RecitalVo recitalVo) {
        recitalVo.setFecha(recitalVo.getFecha());
        return recitalService.guardar(recitalVo);
    }

    @CrossOrigin
    @PostMapping("/recitales/fake")
    public void DataLoad() {
        recitalService.cargarDatos();
    }

    @CrossOrigin
    @GetMapping("/recitales")
    public Page<Recital> buscar(Pageable pageable) {
        return recitalService.buscarTodos(pageable);
    }

    @CrossOrigin
    @GetMapping("/recitales/bandas")
    public Page<Recital> filterGenero(@RequestParam(value = "genero") String genero, Pageable pageable) {
        return recitalService.filterGenero(genero, pageable);
    }

    @CrossOrigin
    @GetMapping("/recitales/{id}")
    public Recital obtenerRecitalId(@PathVariable(value = "id") Long id) {
        return recitalService.buscarPorId(id);
    }

}
