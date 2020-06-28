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

import com.qa.hwa.dto.StampDto;
import com.qa.hwa.persistence.domain.Stamp;
import com.qa.hwa.service.StampService;

@RestController
@RequestMapping("/stamp")
@CrossOrigin
public class StampController {

	private StampService service;
	
	public StampController(StampService service) {
		super();
		this.service = service;
	}

	
	@PostMapping("/create")
	public ResponseEntity<StampDto> create(@RequestBody Stamp stamp) {
		return new ResponseEntity<StampDto>(this.service.create(stamp), HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<StampDto>> read() {
		return new ResponseEntity<List<StampDto>>(this.service.read(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<StampDto> update(@PathVariable Long id, @RequestBody Stamp stamp) {
		return new ResponseEntity<StampDto>(this.service.update(stamp, id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		if (this.service.delete(id)) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
