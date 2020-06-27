package ar.edu.unq.circuito.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.IniciativaRecital;
import ar.edu.unq.circuito.model.Usuario;
import ar.edu.unq.circuito.repo.BandaRepository;
import ar.edu.unq.circuito.repo.IniciativaRecitalRepository;
import ar.edu.unq.circuito.repo.UsuarioRepository;
import ar.edu.unq.circuito.vo.BandaVo;
import ar.edu.unq.circuito.vo.IniciativaRecitalVo;

@Transactional
@Service
public class IniciativaRecitalService {

	@Autowired
	private IniciativaRecitalRepository iniciativaRepository;
	@Autowired
    private BandaRepository bandaRepository;
	@Autowired
    private UsuarioRepository usuarioRepository;
	
	public void guardar(IniciativaRecitalVo iniciativaVo) {
		if (!usuarioRepository.existsById(iniciativaVo.getBanda().getUsuarioId())) {
            throw new NoSuchElementException("El id de usuario no existe");
        }
        Usuario usuario = usuarioRepository.findById(iniciativaVo.getBanda().getUsuarioId()).get();
        		
		IniciativaRecital iniciativa = new IniciativaRecital();
		iniciativa.setDescripcion(iniciativaVo.getDescripcion());
		iniciativa.setDireccion(iniciativaVo.getDireccion());
		iniciativa.setLugar(iniciativaVo.getLugar());
		iniciativa.setLocalidad(iniciativaVo.getLocalidad());
		iniciativa.setFecha(iniciativaVo.getFecha());
		iniciativa.setHora(iniciativaVo.getHora());
		iniciativa.setTelefono(iniciativaVo.getTelefono());
		iniciativa.setUsuario(usuario);
		iniciativa.setBanda(procesarBanda(iniciativaVo.getBanda()));
		iniciativaRepository.save(iniciativa);
	}

	private Banda procesarBanda(BandaVo banda) {
		Banda bandaObtenida = bandaRepository.findById(banda.getId()).get();
		return bandaObtenida;
	}

	public Page<IniciativaRecitalVo> buscarTodos(Pageable pageable) {
		Page<IniciativaRecital> listaIniciativa = iniciativaRepository.findAll(pageable);
		List<IniciativaRecitalVo> newListIniciativa = new ArrayList();
		listaIniciativa.getContent().forEach((i) -> {
			IniciativaRecitalVo newIniciativa = new IniciativaRecitalVo();
			newIniciativa.setId(i.getId());
			newIniciativa.setDescripcion(i.getDescripcion());
		    newIniciativa.setFecha(i.getFecha());
		    newIniciativa.setHora(i.getHora());
		    newIniciativa.setDireccion(i.getDireccion());
		    newIniciativa.setLocalidad(i.getLocalidad());
		    newIniciativa.setLugar(i.getLugar());
		    newIniciativa.setTelefono(i.getTelefono());
		    
		    BandaVo bandaVo = new BandaVo();
		    bandaVo.setId(i.getBanda().getId());
		    bandaVo.setNombre(i.getBanda().getNombre());
		    bandaVo.setImagen(i.getBanda().getImagen());
		    newIniciativa.setBanda(bandaVo);
		    
		    newListIniciativa.add(newIniciativa);
		});
		Page<IniciativaRecitalVo> n = new PageImpl<>(newListIniciativa, pageable, listaIniciativa.getTotalElements());
		return n;
	}

}
