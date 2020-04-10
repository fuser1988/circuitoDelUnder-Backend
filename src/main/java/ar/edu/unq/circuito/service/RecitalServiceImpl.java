package ar.edu.unq.circuito.service;

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
		dao.save(recital);
		
	}

}
