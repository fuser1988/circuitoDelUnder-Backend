package ar.edu.unq.circuito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.repo.BandaRepository;

@Service
public class BandaService {

	@Autowired
	private BandaRepository bandaRepository;
	
	public Banda guardar(Banda banda) {
		return bandaRepository.save(banda);
	}

	public List<Banda> buscarTodos() {
		return bandaRepository.findAll();
	}

}
