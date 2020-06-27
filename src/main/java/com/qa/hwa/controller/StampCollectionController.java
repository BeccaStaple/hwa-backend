package com.qa.hwa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.persistence.domain.StampCollection;
import com.qa.hwa.service.StampCollectionService;



@RestController
@RequestMapping("/collection")
@CrossOrigin
public class StampCollectionController {

	private StampCollectionService service;
	
	public StampCollectionController(StampCollectionService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/create")
	public StampCollection create(StampCollection collection) {
		return this.service.create(collection);
	}
	
	@GetMapping("/read")
	public List<StampCollection> read() {
		return this.service.read();
	}
	
	@PutMapping("/update")
	public StampCollection update() {
		return null;
	}
	
	@DeleteMapping("/delete")
	public boolean delete() {
		return false;
	}
}
