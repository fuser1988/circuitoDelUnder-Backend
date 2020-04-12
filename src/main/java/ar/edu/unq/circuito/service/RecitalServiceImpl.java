package ar.edu.unq.circuito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.RecitalDao;

@Service
public class RecitalServiceImpl implements RecitalService{
	
	@Autowired
	private RecitalDao dao;

	@Override
	public void guardar(Recital recital) {
	// prop. guarda el recital a la base de datos
		dao.save(recital);	
	}

	@Override
	public List<Recital> get() {
	// prop. retorna todos los recitales de la base de datos
		return dao.findAll();
	}

}
