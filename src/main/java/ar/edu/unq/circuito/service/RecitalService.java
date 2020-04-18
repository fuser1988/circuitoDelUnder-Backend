package ar.edu.unq.circuito.service;

import java.util.List;

import ar.edu.unq.circuito.model.Recital;

public interface RecitalService {

	public void guardar(Recital recital);

	public List<Recital> buscarTodos();

	public List<Recital> filterGenero(String genero);
        
        public void cargarDatos();
}
