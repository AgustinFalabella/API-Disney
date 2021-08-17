package com.Disney.services;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.Disney.entities.Base;
import com.Disney.repositories.BaseRepository;


public class BaseServiceImpl <E extends Base, ID extends Serializable> implements BaseService<E, ID>{

	protected BaseRepository<E, ID> baseRepository;

	public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
		this.baseRepository =baseRepository;

	}

	@Override
	@Transactional
	public List<E> findAll() throws Exception {
		List<E> entities = baseRepository.findAll();
		return entities;
	}


	@Override
	@Transactional
	public E findById(ID id) throws Exception {
		Optional<E> entityOptional = baseRepository.findById(id);
		return entityOptional.get();
	}

	@Override
	@Transactional
	public E save(E entity) throws Exception {
		entity = baseRepository.save(entity);
		return entity;
	}

	@Override
	@Transactional
	public E update(ID id, E entity) throws Exception {
		Optional<E> entityOptional = baseRepository.findById(id);
		E entityUpdate=entityOptional.get();
		entityUpdate= baseRepository.save(entity);
		return entityUpdate;
	}

	@Override
	@Transactional
	public boolean delete(ID id) throws Exception {
		if(baseRepository.existsById(id)) {
			baseRepository.deleteById(id);
		return true;
	}
		return false;


	}

}