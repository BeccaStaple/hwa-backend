package com.qa.hwa.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.hwa.dto.StampDto;
import com.qa.hwa.exceptions.StampNotFoundException;
import com.qa.hwa.persistence.domain.Stamp;
import com.qa.hwa.persistence.repo.StampRepo;

@Service
public class StampService {

	private StampRepo repo;
	private ModelMapper mapper;
	
	
	public StampService(StampRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private StampDto mapToDto(Stamp stamp) {
		return this.mapper.map(stamp, StampDto.class);
	}
	
	public StampDto create(Stamp stamp) {
		Stamp savedStamp = this.repo.save(stamp);
		return this.mapToDto(savedStamp);
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
