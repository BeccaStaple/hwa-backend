package com.qa.hwa.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	
	public Stamp update() {
		return null;
	}
	
	public boolean delete() {
		return false;
	}
}
