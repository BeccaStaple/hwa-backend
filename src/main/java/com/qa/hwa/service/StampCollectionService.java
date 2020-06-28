package com.qa.hwa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.hwa.dto.StampCollectionDto;
import com.qa.hwa.exceptions.StampCollectionNotFoundException;
import com.qa.hwa.persistence.domain.StampCollection;
import com.qa.hwa.persistence.repo.StampCollectionRepo;

@Service
public class StampCollectionService {

	private StampCollectionRepo repo;
	private ModelMapper mapper;

	public StampCollectionService(StampCollectionRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	public StampCollectionDto mapToDto(StampCollection collection) {
		return this.mapper.map(collection, StampCollectionDto.class);
	}

	public StampCollectionDto create(StampCollection collection) {
		StampCollection savedCollection = this.repo.save(collection);
		return this.mapToDto(savedCollection);
	}

	public List<StampCollectionDto> read() {
		List<StampCollectionDto> dtos = new ArrayList<>();
		for (StampCollection collection : this.repo.findAll()) {
			dtos.add(this.mapToDto(collection));
		}
		return dtos;
	}

	public StampCollectionDto update(StampCollection collection, Long id) {
		Optional<StampCollection> collectOpt = this.repo.findById(id);

		StampCollection collectUpdate = collectOpt.orElseThrow(() -> new StampCollectionNotFoundException());

		collectUpdate.setTheme(collection.getTheme());
		collectUpdate.setValue(collection.getValue());
		
		StampCollection savedCollection = this.repo.save(collectUpdate);
		return this.mapToDto(savedCollection);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

}
