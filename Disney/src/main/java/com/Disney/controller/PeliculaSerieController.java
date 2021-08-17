package com.Disney.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Disney.entities.Genero;
import com.Disney.entities.PeliculaSerie;
import com.Disney.services.PeliculaSerieServiceImpl;

@RestController
@CrossOrigin (origins ="*")
@RequestMapping(path = "/movies")
public class PeliculaSerieController extends BaseControllerImpl <PeliculaSerie, PeliculaSerieServiceImpl> {

	@GetMapping(" ")
	public ResponseEntity<?> findByTituloContainingOrGenero(@RequestParam(required=false) String name,  @RequestParam(required=false) Genero genre,  Pageable pageable){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.findByTituloContainingOrGenero(name, genre, pageable));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}