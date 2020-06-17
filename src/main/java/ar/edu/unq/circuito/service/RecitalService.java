package ar.edu.unq.circuito.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.model.Ubicacion;
import ar.edu.unq.circuito.repo.BandaRepository;
import ar.edu.unq.circuito.repo.RecitalRepository;
import ar.edu.unq.circuito.util.DatabaseLoader;
import ar.edu.unq.circuito.vo.BandaVo;
import ar.edu.unq.circuito.vo.RecitalVo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;

@Transactional
@Service
public class RecitalService {

    @Autowired
    private RecitalRepository recitalRepository;
    @Autowired
    private DatabaseLoader dataBaseLoader;
    @Autowired
    private BandaRepository bandaRepository;

    public Recital guardar(RecitalVo recitalVo) {
        Recital res = new Recital();
        res.setNombre(recitalVo.getNombre());
        res.setDescripcion(recitalVo.getDescripcion());
        res.setDireccion(recitalVo.getDireccion());
        res.setFecha(recitalVo.getFecha());
        res.setHora(recitalVo.getHora());
        res.setLocalidad(recitalVo.getLocalidad());
        res.setLugar(recitalVo.getLugar());
        res.setImagen(recitalVo.getImagen());
        res.setPrecio(recitalVo.getPrecio());
        res.setBandas(procesarBandas(recitalVo.getBandas()));
        res.setUbicacion(recitalVo.getUbicacion());
        
        return recitalRepository.save(res);
    }

    private List<Banda> procesarBandas(List<BandaVo> bandasVo) {
        List<Banda> listaBandas = new ArrayList<Banda>();
        bandasVo.forEach((banda) -> {
            Banda bandaObtenida = bandaRepository.findById(banda.getId()).get();
            listaBandas.add(bandaObtenida);
        });
        return listaBandas;
    }

    public Page<Recital> buscarTodos(Pageable pageable) {
        return recitalRepository.findAll(pageable);
    }

    public Page<Recital> filterGenero(String genero, Pageable pageable) {
        return recitalRepository.findByGeneros(genero.toUpperCase(), pageable);
    }

    public Recital buscarPorId(long id) {
        return recitalRepository.findById(id).get();
    }

    public void cargarDatos() {
        try {
            dataBaseLoader.run();
        } catch (Exception ex) {
            Logger.getLogger(RecitalService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	public Page<Recital> filterUbicacion(Ubicacion ubicacion, Pageable pageable) {
		return recitalRepository.findByUbicacion(ubicacion.getLatitud(), ubicacion.getLongitud(), pageable);
	}

}
