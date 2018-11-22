package com.cua.escuelared.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Asistencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@OneToOne @MapsId
	Usuario usuario;
	
	@Column
	boolean asistioFechaUno;
	
	@Column
	boolean asistioFechaDos;
	
	@Column
	boolean asistioFechaTres;
	
	@Column
	boolean asistioFechaCuatro;
	
	@Column
	boolean asistioFechaCinco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean getAsistioFechaUno() {
		return asistioFechaUno;
	}

	public void setAsistioFechaUno(boolean asistioFechaUno) {
		this.asistioFechaUno = asistioFechaUno;
	}

	public boolean getAsistioFechaDos() {
		return asistioFechaDos;
	}

	public void setAsistioFechaDos(boolean asistioFechaDos) {
		this.asistioFechaDos = asistioFechaDos;
	}

	public boolean getAsistioFechaTres() {
		return asistioFechaTres;
	}

	public void setAsistioFechaTres(boolean asistioFechaTres) {
		this.asistioFechaTres = asistioFechaTres;
	}

	public boolean getAsistioFechaCuatro() {
		return asistioFechaCuatro;
	}

	public void setAsistioFechaCuatro(boolean asistioFechaCuatro) {
		this.asistioFechaCuatro = asistioFechaCuatro;
	}

	public boolean getAsistioFechaCinco() {
		return asistioFechaCinco;
	}

	public void setAsistioFechaCinco(boolean asistioFechaCinco) {
		this.asistioFechaCinco = asistioFechaCinco;
	}
	
	
	
}
