package com.Disney.entities;


import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Personaje extends Base {

	@Column
	private Blob imagen;
	@Column
	private String nombre;
	@Column
	private Integer edad;
	@Column
	private Integer peso;
	@Column
	private String historia;

	@ManyToMany(targetEntity = PeliculaSerie.class, fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "personaje_peliculaSerie", joinColumns = @JoinColumn(name = "personaje_id"), inverseJoinColumns = @JoinColumn(name = "peliculaSerie_id"))
	private List<PeliculaSerie> peliculaSerie = new ArrayList<PeliculaSerie>();



	public Personaje() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Personaje(Blob imagen, String nombre) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
	}


	public Personaje(Blob imagen, String nombre, Integer edad, Integer peso, String historia,
			List<PeliculaSerie> peliculaSerie) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.historia = historia;
		this.peliculaSerie = peliculaSerie;
	}

	public Blob getImagen() {
		return imagen;
	}

	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public List<PeliculaSerie> getPeliculaSerie() {
		return peliculaSerie;
	}

	public void setPeliculaSerie(List<PeliculaSerie> peliculaSerie) {
		this.peliculaSerie = peliculaSerie;
	}


	public static Object stream() {
		// TODO Auto-generated method stub
		return null;
	}

}