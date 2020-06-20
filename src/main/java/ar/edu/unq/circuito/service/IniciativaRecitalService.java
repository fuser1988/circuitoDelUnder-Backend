package ar.edu.unq.circuito.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.IniciativaRecital;
import ar.edu.unq.circuito.repo.IniciativaRecitalRepository;

@Transactional
@Service
public class IniciativaRecitalService {

	@Autowired
	private IniciativaRecitalRepository iniciativaRepository;
	
	public void guardar(IniciativaRecital iniciativa) {
		iniciativaRepository.save(iniciativa);
	}

	public Page<IniciativaRecital> buscarTodos(Pageable pageable) {
		return iniciativaRepository.findAll(pageable);
	}

}
