package com.Disney.entities;


import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class PeliculaSerie extends Base {

	@Column
	private Blob imagen;
	@Column
	private String titulo;
	@Column
	private Integer fechaCreacion;
	@Column
	private Integer calificacion;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "genero")
	private Genero genero;

	@ManyToMany(mappedBy = "peliculaSerie", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Personaje> personaje = new ArrayList<Personaje>();




	public PeliculaSerie(Blob imagen, String titulo, Integer fechaCreacion, Integer calificacion, Genero genero) {
		super();
		this.imagen = imagen;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.calificacion = calificacion;
		this.genero = genero;
	}

	public PeliculaSerie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blob getImagen() {
		return imagen;
	}

	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Integer fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {

		if (calificacion > 5) {
			this.calificacion = 5;
		} else if (calificacion < 1) {
			this.calificacion = 1;
		} else {
			this.calificacion = calificacion;
		}

	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}



} 