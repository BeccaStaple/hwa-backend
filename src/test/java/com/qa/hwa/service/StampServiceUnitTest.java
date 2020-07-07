package com.qa.hwa.service;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.qa.hwa.dto.StampDto;
import com.qa.hwa.persistence.domain.Stamp;
import com.qa.hwa.persistence.repo.StampRepo;

@RunWith(MockitoJUnitRunner.class)
public class StampServiceUnitTest {

	private final Stamp STAMP = new Stamp("star", 1.11, 1996);
	
	private Stamp savedStamp;
	
	private StampDto stampDto;
	
	@Mock
	private StampRepo repo;
	
	@Mock
	private ModelMapper mapper;
	
	@InjectMocks
	private StampService service;
	
	@Before
	public void init() {
		this.savedStamp = new Stamp(STAMP.getName(), STAMP.getValue(), STAMP.getYearMade());
		this.savedStamp.setId(1L);
		this.stampDto = new ModelMapper().map(savedStamp,  StampDto.class);
	}
	
	@Test
	public void testCreate() {
		
		Mockito.when(this.repo.save(STAMP)).thenReturn(savedStamp);
		Mockito.when(this.mapper.map(savedStamp, StampDto.class)).thenReturn(stampDto);
		
		StampDto createdStampDto = this.stampDto;
		
		assertEquals(createdStampDto, service.create(STAMP));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(STAMP);
	}
	
	@Test
	public void testRead() {
		List<Stamp> stampList = new ArrayList<Stamp>();
		
		stampList.add(savedStamp);
		
		Mockito.when(this.repo.findAll()).thenReturn(stampList);
		Mockito.when(this.mapper.map(savedStamp, StampDto.class)).thenReturn(stampDto);
		
		assertFalse(service.read().isEmpty());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		
	}
	
	//need test for readOne()
	
	@Test
	public void testUpdate() {
		
		Mockito.when(this.repo.findById(savedStamp.getId())).thenReturn(Optional.of(savedStamp));
	
		Stamp newStamp = new Stamp("updated stamp", 1.99, 1900);
		
		Stamp stampPlusId = new Stamp("updated stamp", 1.99, 1900);
		stampPlusId.setId(savedStamp.getId());
		
		StampDto stampToDtoID = service.mapToDto(stampPlusId);
		
		Mockito.when(this.repo.save(stampPlusId)).thenReturn(stampPlusId);
		
		assertEquals(stampPlusId, this.service.update(newStamp, savedStamp.getId()));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(savedStamp.getId());
		Mockito.verify(this.repo, Mockito.times(1)).save(stampPlusId);
	}
	
	@Test
	public void testDelete() {
		final long ID = 1L;
		final boolean RESULT = false;
		
		Mockito.when(this.repo.existsById(ID)).thenReturn(false);
		
		assertEquals(RESULT, this.service.delete(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(ID);
	}
	
	
	
}
