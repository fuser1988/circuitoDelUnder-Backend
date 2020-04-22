package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.model.Genero;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.RecitalRepository;
import ar.edu.unq.circuito.util.DatabaseLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class RecitalServiceImpl implements RecitalService {

    @Autowired
    private RecitalRepository recitalRepository;

    @Override
    public void guardar(Recital recital) {
        recitalRepository.save(recital);
    }

    @Override
    public List<Recital> buscarTodos() {
        return recitalRepository.findAll();
    }

    @Override
    public List<Recital> filterGenero(String genero) {
    	int index = Genero.valueOf(genero.toUpperCase()).ordinal();
    	return recitalRepository.findByGeneros(index);
    }

    @Override
    public void cargarDatos() {
        try {
            DatabaseLoader dataBaseLoader = new DatabaseLoader(recitalRepository);
            dataBaseLoader.run();
        } catch (Exception ex) {
            Logger.getLogger(RecitalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
