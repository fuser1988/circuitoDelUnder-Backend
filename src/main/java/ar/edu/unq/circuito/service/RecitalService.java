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
public class RecitalService {

    @Autowired
    private RecitalRepository recitalRepository;
    @Autowired
    private DatabaseLoader dataBaseLoader;

    public void guardar(Recital recital) {
        recitalRepository.save(recital);
    }

    public List<Recital> buscarTodos() {
        return recitalRepository.findAll();
    }

    public List<Recital> filterGenero(String genero) {
//        int index = Genero.valueOf(genero.toUpperCase()).ordinal();
        return recitalRepository.findByGeneros(genero.toUpperCase());
    }

    public void cargarDatos() {
        try {
            dataBaseLoader.run();
        } catch (Exception ex) {
            Logger.getLogger(RecitalService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
