package com.qa.hwa.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Stamp create(@RequestBody Stamp stamp) {
		return this.service.create(stamp);
	}
	
	@GetMapping("/read")
	public List<Stamp> read() {
		return this.service.read();
	}
}
