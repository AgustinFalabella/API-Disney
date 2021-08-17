package com.Disney.entities;


import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Genero extends Base {

	@Column(unique= true)
	private String nombre;
	@Column
	private Blob imagen;

	@OneToMany(mappedBy = "genero", cascade = CascadeType.ALL )
	private List<PeliculaSerie> peliculaSerie = new ArrayList<PeliculaSerie>();

	public Genero(String nombre, Blob imagen, List<PeliculaSerie> peliculaSerie) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.peliculaSerie = peliculaSerie;
	}

	public Genero() {
		super();
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Blob getImagen() {
		return imagen;
	}

	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}



}