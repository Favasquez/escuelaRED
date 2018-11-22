package com.cua.escuelared.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cua.escuelared.entity.Asistencia;
import com.cua.escuelared.repository.AsistenciaRepository;
import com.cua.escuelared.repository.UsuarioRepository;

@RestController
public class AsistenciaController {

	@Autowired
	private AsistenciaRepository asistenciaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/asistencia/registrar")
	public Asistencia registrarAsistencia(@RequestBody Asistencia asistencia) {
		
		return asistenciaRepository.findByUsuario(
				usuarioRepository.findByCedula(asistencia.getUsuario().getCedula()).
				orElseThrow(() -> new RuntimeException("No se encontró el usuario"))).
			map(asis ->{
				asis.setAsistioFechaUno(asistencia.getAsistioFechaUno());
				asis.setAsistioFechaDos(asistencia.getAsistioFechaDos());
				asis.setAsistioFechaTres(asistencia.getAsistioFechaTres());
				asis.setAsistioFechaCuatro(asistencia.getAsistioFechaCuatro());
				asis.setAsistioFechaCinco(asistencia.getAsistioFechaCinco());
				return asistenciaRepository.save(asis);
			}).orElseGet(() -> {
				return asistenciaRepository.save(asistencia);
			});
	}
	
	@GetMapping("asistencia/asistencias-usuario")
	public List<Asistencia> asistenciasDeUsuario(){
		return asistenciaRepository.findAll();
	}
}
