package com.Disney.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Disney.entities.PeliculaSerie;
import com.Disney.entities.Personaje;
import com.Disney.services.PersonajeServiceImpl;

@RestController
@CrossOrigin (origins ="*")
@RequestMapping(path = "/characters")
public class PersonajeController extends BaseControllerImpl <Personaje, PersonajeServiceImpl> {

	@GetMapping(" ")
	public ResponseEntity<?> findByNombreOrEdadOrPeliculaSerie(@RequestParam(required=false) String name, @RequestParam (required=false) Integer age, @RequestParam (required=false) PeliculaSerie movies){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.findByNombreOrEdadOrPeliculaSerie(name, age, movies));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}