package com.qa.hwa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.dto.StampCollectionDto;
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
	public ResponseEntity<StampCollectionDto> create(@RequestBody StampCollection collection) {
		return new ResponseEntity<StampCollectionDto>(this.service.create(collection), HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<StampCollectionDto>> read() {
		return new ResponseEntity<List<StampCollectionDto>>(this.service.read(), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<StampCollectionDto> update(@PathVariable Long id, @RequestBody StampCollection collection) {
		return new ResponseEntity<StampCollectionDto>(this.service.update(collection, id), HttpStatus.ACCEPTED);	
		}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if (this.service.delete(id)) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
