package com.qa.hwa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwa.dto.StampDto;
import com.qa.hwa.persistence.domain.Stamp;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StampControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	private Stamp stamp;

	private Stamp savedStamp;
	
	private StampDto stampDto;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private ModelMapper modelMapper;

	@Before
	public void init() {
		this.stamp = new Stamp("integ test stamp", 23.45, 2011);
		this.savedStamp = new Stamp(stamp.getName(), stamp.getValue(), stamp.getYearMade());
		this.savedStamp.setId(1L);
		this.stampDto = this.modelMapper.map(savedStamp, StampDto.class);
	}

	@Test
	public void testCreate() throws Exception {
		this.mockMvc.perform(post("/stamp/create")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(stampDto)))
				.andExpect(status().isCreated()).andExpect(content().json(this.mapper.writeValueAsString(stampDto)));

	}

}
