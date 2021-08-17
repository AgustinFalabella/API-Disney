package com.Disney.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Disney.entities.Genero;
import com.Disney.entities.PeliculaSerie;
import com.Disney.repositories.BaseRepository;
import com.Disney.repositories.PeliculaSerieRepository;

@Service
public class PeliculaSerieServiceImpl extends BaseServiceImpl<PeliculaSerie, Long> implements PeliculaSerieService {

	public PeliculaSerieServiceImpl(BaseRepository<PeliculaSerie, Long> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private PeliculaSerieRepository peliculaSerieRepository;

	public Page<PeliculaSerie> findByTituloContainingOrGenero(String name, Genero genre, Pageable pageable) throws Exception{
		Page<PeliculaSerie> peliculaSerie = peliculaSerieRepository.findByTituloContainingOrGenero(name, genre, pageable);
		return peliculaSerie;
	}
}