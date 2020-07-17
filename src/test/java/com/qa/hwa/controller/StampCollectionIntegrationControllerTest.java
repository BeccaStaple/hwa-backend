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
import com.qa.hwa.dto.StampCollectionDto;
import com.qa.hwa.persistence.domain.StampCollection;
import com.qa.hwa.persistence.repo.StampCollectionRepo;
import com.qa.hwa.service.StampCollectionService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StampCollectionIntegrationControllerTest {

	private StampCollection collection;

	private StampCollection savedCollection;

	private StampCollectionDto collectionDto;

	private long id;

	private List<StampCollectionDto> listCollectionDto;

	@Autowired
	private StampCollectionService service;

	@Autowired
	private StampCollectionRepo repo;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private ModelMapper modelMapper;

	@Before
	public void init() {
		this.id = 1L;
		this.collection = new StampCollection("test collection", 12.34);
		this.savedCollection = new StampCollection(collection.getTheme(), collection.getValue());
		this.savedCollection.setId(this.id);
		this.service = new StampCollectionService(repo, modelMapper);
		this.collectionDto = service.mapToDto(savedCollection);
		this.listCollectionDto = new ArrayList<StampCollectionDto>();
	}

	@Test
	public void testCreate() throws JsonProcessingException, Exception {
		this.mockMvc
				.perform(post("/collection/create").contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(collectionDto)))
				.andExpect(status().isCreated())
				.andExpect(content().json(this.mapper.writeValueAsString(collectionDto)));

	}

	@Test
	public void testRead() throws JsonProcessingException, Exception {
		this.mockMvc
				.perform(get("/collection/read").contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(listCollectionDto)));

	}

	@Test
	public void testReadOne() throws JsonProcessingException, Exception {
		this.service.create(savedCollection);

		this.mockMvc
				.perform(get("/collection/read/" + this.id).contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(this.mapper.writeValueAsString(collectionDto)));

	}
	
	@Test
	public void testUpdate() throws JsonProcessingException, Exception {
		this.service.create(savedCollection);
		
		StampCollection testCollection = new StampCollection("updated collection", 33.99);

		StampCollection updateCollection = new StampCollection(testCollection.getTheme(), testCollection.getValue());
		updateCollection.setId(this.id);
		
		StampCollectionDto colToDto = this.service.mapToDto(updateCollection);

		this.mockMvc
				.perform(put("/collection/update/" + this.id).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(updateCollection)))
				.andExpect(status().isAccepted()).andExpect(content().json(this.mapper.writeValueAsString(colToDto)));
	}
	
	@Test
	public void testDelete() throws Exception {
		this.mockMvc.perform(delete("/collection/delete/" + this.id).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
	}
	

}
