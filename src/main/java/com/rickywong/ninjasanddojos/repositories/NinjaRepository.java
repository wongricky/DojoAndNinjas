package com.rickywong.ninjasanddojos.repositories;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rickywong.ninjasanddojos.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
	
	List<Ninja> findByDojoId(Long dojo_Id, Pageable pageable);
}
