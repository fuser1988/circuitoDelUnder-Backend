package ar.edu.unq.circuito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.service.BandaService;
import ar.edu.unq.circuito.vo.BandaVo;

@RestController
@RequestMapping("/circuito_under")
public class BandaController {

    @Autowired
    BandaService bandaService;

    @CrossOrigin
    @PostMapping("/banda")
    public Banda guardar(@RequestBody BandaVo bandavo) {
        return bandaService.guardarBandaNueva(bandavo);
    }

    @CrossOrigin
    @GetMapping("/bandasRef")
    public List<BandaVo> buscarRef() {
        return bandaService.buscarTodosRef();
    }
    
    @CrossOrigin
    @GetMapping("/bandas")
    public Page<Banda> buscar(Pageable pageable) {
        return bandaService.buscarTodos(pageable);
    }
    
    @CrossOrigin
    @GetMapping("/bandas/genero")
    public Page<Banda> filterGenero(@RequestParam(value = "genero") String genero, Pageable pageable) {
        return bandaService.filterGenero(genero, pageable);
    }
    
    @CrossOrigin
    @GetMapping("/bandas/banda")
    public Page<Banda> filterNombre(@RequestParam(value = "nombre") String nombre, Pageable pageable) {
        return bandaService.filterNombre(nombre, pageable);
    }
    
    @CrossOrigin
    @GetMapping("/bandas/{id}")
    public Banda obtenerBandaId(@PathVariable(value = "id") Long id) {
        return bandaService.buscarPorId(id);
    }
}
