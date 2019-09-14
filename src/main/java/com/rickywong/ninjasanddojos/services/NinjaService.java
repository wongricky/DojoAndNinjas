package com.rickywong.ninjasanddojos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rickywong.ninjasanddojos.models.Ninja;
import com.rickywong.ninjasanddojos.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	
	
	
}
