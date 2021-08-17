package com.Disney.repositories;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.Disney.entities.PeliculaSerie;
import com.Disney.entities.Personaje;

@Repository
public interface PersonajeRepository extends BaseRepository<Personaje, Long> {

	List<Personaje> findByNombreOrEdadOrPeliculaSerie(String name, Integer age, PeliculaSerie movies);



	//@Query(value="select distinct p.* from personaje p LEFT JOIN personaje_pelicula_serie pps ON (p.id=pps.personaje_id) where (?1 IS NULL OR p.Nombre = ?1 AND ((?2 IS NULL AND ?3 IS NULL) OR (?2 IS NULL AND ?3 IS NOT NULL AND pps.pelicula_serie_id = ?3) OR (?3 IS NULL AND ?2 IS NOT NULL AND p.Edad = ?2) OR (p.Edad = ?2 OR pps.pelicula_serie_id = ?3))", nativeQuery=true)

}