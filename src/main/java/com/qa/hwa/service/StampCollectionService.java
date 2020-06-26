package com.qa.hwa.service;

import java.util.List;
import java.util.Optional;

import com.qa.hwa.exceptions.StampNotFoundException;
import com.qa.hwa.persistence.domain.StampCollection;
import com.qa.hwa.persistence.repo.StampCollectionRepo;

public class StampCollectionService {

	private StampCollectionRepo repo;

	public StampCollectionService(StampCollectionRepo repo) {
		super();
		this.repo = repo;
	}

	public StampCollection create(StampCollection collection) {
		return this.repo.save(collection);
	}

	public List<StampCollection> read() {
		return this.repo.findAll();
	}

	public StampCollection update(StampCollection collection, Long id) {
		Optional<StampCollection> collectOpt = this.repo.findById(id);

		StampCollection collectUpdate = collectOpt.orElseThrow(() -> new StampNotFoundException());

		collectUpdate.setValue(collection.getValue());
		collectUpdate.setTheme(collection.getTheme());

		return this.repo.save(collectUpdate);
	}

	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}

}
