package ar.edu.unq.circuito.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.TipoUsuario;
import ar.edu.unq.circuito.model.Usuario;
import ar.edu.unq.circuito.repo.BandaRepository;
import ar.edu.unq.circuito.repo.UsuarioRepository;
import ar.edu.unq.circuito.vo.BandaVo;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class BandaService {

    @Autowired
    private BandaRepository bandaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Banda guardarBandaNueva(BandaVo bandaVo) {
        if (!usuarioRepository.existsById(bandaVo.getUsuarioId())) {
            throw new NoSuchElementException("El id de usuario no existe");
        }
        Usuario usuario = usuarioRepository.findById(bandaVo.getUsuarioId()).get();
        usuario.setTipoUsuario(TipoUsuario.REGISTRADO_CON_BANDA);
        Banda banda = new Banda();
        banda.setNombre(bandaVo.getNombre());
        banda.setImagen(bandaVo.getImagen());
        banda.setInfo(bandaVo.getInfo());
        banda.setGeneros(procesarGeneros(bandaVo.getGeneros()));
        banda.setUsuario(usuario);
        banda.setMaterial(bandaVo.getMaterial());
        return bandaRepository.save(banda);
    }

    private List<Genero> procesarGeneros(List<String> generos) {
        return generos.stream().map((genero) -> {
            return new Genero(genero);
        }).collect(Collectors.toList());
    }

    public List<BandaVo> buscarTodos() {
        List<Banda> listaBanda = bandaRepository.findAll();
        List<BandaVo> listaBandaVo = new ArrayList<BandaVo>();
        listaBanda.forEach((b) -> {
            BandaVo newB = new BandaVo();
            newB.setId(b.getId());
            newB.setNombre(b.getNombre());
            listaBandaVo.add(newB);
        });
        return listaBandaVo;
    }

	public List<Banda> filterGenero(String genero) {
		return bandaRepository.findByGeneros(genero.toUpperCase());
	}

	public List<Banda> filterNombre(String nombre) {
		return bandaRepository.findByNombre(nombre.toLowerCase());
	}

}
