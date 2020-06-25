package ar.edu.unq.circuito.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.IniciativaRecital;
import ar.edu.unq.circuito.model.Usuario;
import ar.edu.unq.circuito.repo.IniciativaRecitalRepository;
import ar.edu.unq.circuito.vo.BandaVo;
import ar.edu.unq.circuito.vo.IniciativaRecitalVo;

@Transactional
@Service
public class IniciativaRecitalService {

	@Autowired
	private IniciativaRecitalRepository iniciativaRepository;
	
	public void guardar(IniciativaRecital iniciativa) {
		iniciativaRepository.save(iniciativa);
	}

	public Page<IniciativaRecitalVo> buscarTodos(Pageable pageable) {
		Page<IniciativaRecital> listaIniciativa = iniciativaRepository.findAll(pageable);
		List<IniciativaRecitalVo> newListIniciativa = new ArrayList();
		listaIniciativa.getContent().forEach((i) -> {
			IniciativaRecitalVo newIniciativa = new IniciativaRecitalVo();
			newIniciativa.setId(i.getId());
			newIniciativa.setNombre(i.getNombre());
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
