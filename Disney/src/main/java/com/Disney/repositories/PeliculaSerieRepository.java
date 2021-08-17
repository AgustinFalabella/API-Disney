package com.Disney.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.Disney.entities.Genero;
import com.Disney.entities.PeliculaSerie;

@Repository
public interface PeliculaSerieRepository extends BaseRepository<PeliculaSerie, Long>{

	Page<PeliculaSerie> findByTituloContainingOrGenero(String name, Genero genre, Pageable pageable);
}