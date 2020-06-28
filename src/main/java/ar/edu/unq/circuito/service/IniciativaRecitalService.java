package ar.edu.unq.circuito.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.IniciativaRecital;
import ar.edu.unq.circuito.model.Usuario;
import ar.edu.unq.circuito.repo.BandaRepository;
import ar.edu.unq.circuito.repo.IniciativaRecitalRepository;
import ar.edu.unq.circuito.repo.UsuarioRepository;
import ar.edu.unq.circuito.vo.BandaVo;
import ar.edu.unq.circuito.vo.IniciativaRecitalVo;

@Transactional
@Service
public class IniciativaRecitalService {

    @Autowired
    private IniciativaRecitalRepository iniciativaRepository;
    @Autowired
    private BandaRepository bandaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void guardar(IniciativaRecitalVo iniciativaVo) {
        if (!usuarioRepository.existsById(iniciativaVo.getBanda().getUsuarioId())) {
            throw new NoSuchElementException("El id de usuario no existe");
        }
        Usuario usuario = usuarioRepository.findById(iniciativaVo.getBanda().getUsuarioId()).get();

        IniciativaRecital iniciativa = crearIniciativaRecital(iniciativaVo, usuario);
        iniciativaRepository.save(iniciativa);
    }

    public Page<IniciativaRecitalVo> buscarTodos(Pageable pageable) {
        Page<IniciativaRecital> listaIniciativaRecital = iniciativaRepository.findAll(pageable);
        return armarPageDeIniciativaRecitalVo(listaIniciativaRecital, pageable);
    }

    private IniciativaRecital crearIniciativaRecital(IniciativaRecitalVo iniciativaVo, Usuario usuario) {
        IniciativaRecital iniciativa = new IniciativaRecital();
        iniciativa.setDescripcion(iniciativaVo.getDescripcion());
        iniciativa.setDireccion(iniciativaVo.getDireccion());
        iniciativa.setLugar(iniciativaVo.getLugar());
        iniciativa.setLocalidad(iniciativaVo.getLocalidad());
        iniciativa.setFecha(iniciativaVo.getFecha());
        iniciativa.setHora(iniciativaVo.getHora());
        iniciativa.setTelefono(iniciativaVo.getTelefono());
        iniciativa.setUsuario(usuario);
        iniciativa.setBanda(procesarBanda(iniciativaVo.getBanda()));
        return iniciativa;
    }

    private Banda procesarBanda(BandaVo banda) {
        Banda bandaObtenida = bandaRepository.findById(banda.getId()).get();
        return bandaObtenida;
    }

    private Page<IniciativaRecitalVo> armarPageDeIniciativaRecitalVo(Page<IniciativaRecital> listaIniciativaRecital, Pageable pageable) {
        List<IniciativaRecitalVo> listaIniciativaRecitalVo = new ArrayList();
        listaIniciativaRecital.getContent().forEach((iniciativaRecital) -> {
            IniciativaRecitalVo newIniciativa = new IniciativaRecitalVo();
            newIniciativa.setId(iniciativaRecital.getId());
            newIniciativa.setDescripcion(iniciativaRecital.getDescripcion());
            newIniciativa.setFecha(iniciativaRecital.getFecha());
            newIniciativa.setHora(iniciativaRecital.getHora());
            newIniciativa.setDireccion(iniciativaRecital.getDireccion());
            newIniciativa.setLocalidad(iniciativaRecital.getLocalidad());
            newIniciativa.setLugar(iniciativaRecital.getLugar());
            newIniciativa.setTelefono(iniciativaRecital.getTelefono());

            BandaVo bandaVo = new BandaVo();
            bandaVo.setId(iniciativaRecital.getBanda().getId());
            bandaVo.setNombre(iniciativaRecital.getBanda().getNombre());
            bandaVo.setImagen(iniciativaRecital.getBanda().getImagen());
            newIniciativa.setBanda(bandaVo);

            listaIniciativaRecitalVo.add(newIniciativa);
        });

        return new PageImpl<>(listaIniciativaRecitalVo, pageable, listaIniciativaRecital.getTotalElements());
    }

    public void borrar(long id) {
        iniciativaRepository.deleteById(id);
    }

}
