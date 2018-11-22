package com.cua.escuelared.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cua.escuelared.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	public Optional<Usuario> findByCedula(String cedula);
}
