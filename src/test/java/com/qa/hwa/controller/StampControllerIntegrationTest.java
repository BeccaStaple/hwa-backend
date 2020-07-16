package com.qa.hwa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwa.dto.StampDto;
import com.qa.hwa.persistence.domain.Stamp;
import com.qa.hwa.persistence.repo.StampRepo;
import com.qa.hwa.service.StampService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StampControllerIntegrationTest {

	private Stamp stamp;

	private Stamp savedStamp;

	private StampDto stampDto;

	private long id;

	private List<StampDto> listStampDto;
	
	@Autowired
	private StampRepo repo;
	
	@Autowired
	private StampService service;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private ModelMapper modelMapper;

	@Before
	public void init() {
		this.id = 1L;
		this.stamp = new Stamp("integ test stamp", 23.45, 2011);
		this.savedStamp = new Stamp(stamp.getName(), stamp.getValue(), stamp.getYearMade());
		this.savedStamp.setId(this.id);
		this.service = new StampService(repo, modelMapper);
		this.stampDto = service.mapToDto(savedStamp);
		this.listStampDto = new ArrayList<StampDto>();
	}

	@Test
	public void testCreate() throws Exception {
		this.mockMvc
				.perform(post("/stamp/create").contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(stampDto)))
				.andExpect(status().isCreated()).andExpect(content().json(this.mapper.writeValueAsString(stampDto)));

	}

	@Test
	public void testRead() throws JsonProcessingException, Exception {
		this.mockMvc
				.perform(get("/stamp/read").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(this.mapper.writeValueAsString(listStampDto)));
	}

	@Test
	public void testReadOne() throws JsonProcessingException, Exception {
		this.service.create(savedStamp);
		
		this.mockMvc
				.perform(get("/stamp/read/" + this.id).contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(this.mapper.writeValueAsString(stampDto)));
	}

	@Test
	public void testUpdate() throws JsonProcessingException, Exception {
		this.service.create(savedStamp);
		
		Stamp testStamp = new Stamp("updatedStamp", 33.99, 2020);

		Stamp updateStamp = new Stamp(testStamp.getName(), testStamp.getValue(), testStamp.getYearMade());
		updateStamp.setId(this.id);

		StampDto stampToDto = this.service.mapToDto(updateStamp);

		this.mockMvc
				.perform(put("/stamp/update/" + this.id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted()).andExpect(content().json(this.mapper.writeValueAsString(stampToDto)));
	}

	@Test
	public void testDelete() throws Exception {
		this.mockMvc.perform(delete("/stamp/delete/" + this.id).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}

}
