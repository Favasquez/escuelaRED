package com.cua.escuelared.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cua.escuelared.entity.Asistencia;
import com.cua.escuelared.entity.Usuario;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer>{

	public Optional<Asistencia> findByUsuario(Usuario usuario);
}