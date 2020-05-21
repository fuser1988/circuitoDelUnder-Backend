package ar.edu.unq.circuito.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.BandaRepository;
import ar.edu.unq.circuito.repo.RecitalRepository;
import ar.edu.unq.circuito.util.DatabaseLoader;
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

        return recitalRepository.save(res);
    }

    private List<Banda> procesarBandas(List<Long> bandasVo) {
        List<Banda> listaBandas = new ArrayList<Banda>();
        bandasVo.forEach((id) -> {
            Banda bandaObtenida = bandaRepository.findById(id).get();
            listaBandas.add(bandaObtenida);
        });
        return listaBandas;
    }

    public List<Recital> buscarTodos() {
        return recitalRepository.findAll();
    }

    public List<Recital> filterGenero(String genero) {
        return recitalRepository.findByGeneros(genero.toUpperCase());
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

}
