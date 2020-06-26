package com.qa.hwa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.hwa.exceptions.StampNotFoundException;
import com.qa.hwa.persistence.domain.Stamp;
import com.qa.hwa.persistence.repo.StampRepo;

@Service
public class StampService {

	public StampRepo repo;
	
	public StampService(StampRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Stamp create(Stamp stamp) {
		return this.repo.save(stamp);
	}
	
	public List<Stamp> read() {
		return repo.findAll(); 
	}
	
	public Stamp update(Stamp stamp, long id) {
		Optional<Stamp> stampOpt = this.repo.findById(id);
		
		Stamp stampUpdate = stampOpt.orElseThrow(() -> new StampNotFoundException());
		
		stampUpdate.setName(stamp.getName());
		stampUpdate.setValue(stamp.getValue());
		stampUpdate.setYearMade(stamp.getYearMade());
		
		return this.repo.save(stampUpdate);
	}
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
}
