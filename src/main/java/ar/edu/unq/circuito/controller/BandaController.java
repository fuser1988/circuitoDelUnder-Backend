package ar.edu.unq.circuito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/bandas")
    public List<BandaVo> buscar() {
        return bandaService.buscarTodos();
    }
    
    @CrossOrigin
    @GetMapping("/bandas/genero")
    public List<Banda> filterGenero(@RequestParam(value = "genero") String genero) {
        return bandaService.filterGenero(genero);
    }
    
    @CrossOrigin
    @GetMapping("/bandas/banda")
    public List<Banda> filterNombre(@RequestParam(value = "nombre") String nombre) {
        return bandaService.filterNombre(nombre);
    }
}
