package com.Disney.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Disney.entities.PeliculaSerie;
import com.Disney.entities.Personaje;
import com.Disney.repositories.BaseRepository;
import com.Disney.repositories.PersonajeRepository;

@Service
public class PersonajeServiceImpl extends BaseServiceImpl<Personaje, Long> implements PersonajeService {

	public PersonajeServiceImpl(BaseRepository<Personaje, Long> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private PersonajeRepository personajeRepository;

	public List<Personaje> findByNombreOrEdadOrPeliculaSerie(String name, Integer age, PeliculaSerie movies)
			throws Exception {
		List<Personaje> personajes = personajeRepository.findByNombreOrEdadOrPeliculaSerie(name, age, movies);
		return personajes;

	}


}