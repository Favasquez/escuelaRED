package com.cua.escuelared.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cua.escuelared.entity.Usuario;
import com.cua.escuelared.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/usuarios/crear/{cedula}")
	public Usuario crearOActualizarUsuario(@RequestBody Usuario nuevoUsuario, @PathVariable String cedula) {
		return usuarioRepository.findByCedula(cedula).map(usuario->{
			usuario.setCedula(cedula);
			usuario.setNombres(nuevoUsuario.getNombres());
			usuario.setPrimerApellido(nuevoUsuario.getPrimerApellido());
			usuario.setSegundoApellido(nuevoUsuario.getSegundoApellido());
			usuario.setCorreo(usuario.getCorreo());
			return usuarioRepository.save(usuario);
		}).orElseGet(() -> {
			nuevoUsuario.setCedula(cedula);
			return usuarioRepository.save(nuevoUsuario);
		});
	}
	
	@GetMapping("/usuarios/todos")
	public List<Usuario> listarUsuarios(){
		return usuarioRepository.findAll();
	}
	
	
}