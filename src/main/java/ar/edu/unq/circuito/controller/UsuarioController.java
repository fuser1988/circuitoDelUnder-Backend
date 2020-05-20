package ar.edu.unq.circuito.controller;


import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.circuito.model.Usuario;
import ar.edu.unq.circuito.service.UsuarioService;
import ar.edu.unq.circuito.vo.CodigoVo;
import ar.edu.unq.circuito.vo.ReferenciaUsuarioVo;


@RestController
@RequestMapping("/circuito_under")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	
	@CrossOrigin
	@PostMapping("/usuario/info")
	public Usuario buscarInformacionDeUsuario(@RequestBody ReferenciaUsuarioVo referenciaUsuarioVo) {
		return usuarioService.identificarUsuarioPorReferencia(referenciaUsuarioVo);
	}
	
    @CrossOrigin
	@PostMapping("/usuario/validacion")
	public Usuario validarCodigoDeVerificacionDeCuenta(@RequestBody CodigoVo codigoVo) {
		return usuarioService.validarCodigoDeUsuario(codigoVo.getCodigo(), codigoVo.getUsuarioId());
	}
    

}
