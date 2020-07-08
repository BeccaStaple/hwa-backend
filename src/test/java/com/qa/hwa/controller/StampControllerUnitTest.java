package com.qa.hwa.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.hwa.dto.StampDto;
import com.qa.hwa.persistence.domain.Stamp;
import com.qa.hwa.persistence.repo.StampRepo;
import com.qa.hwa.service.StampService;

@RunWith(MockitoJUnitRunner.class)
public class StampControllerUnitTest {

	private final Stamp STAMP = new Stamp("controller stamp", 14.99, 1999);
	private final long ID = 1L;
	private Stamp savedStamp;
	private StampDto stampDto;
	@Mock
	private StampRepo repo;
	
	@Mock
	private StampService service;
	
	@InjectMocks
	private StampController controller;
	
	@Before
	public void init() {
		this.savedStamp = new Stamp(STAMP.getName(), STAMP.getValue(), STAMP.getYearMade());
		this.savedStamp.setId(ID);
		this.stampDto = service.mapToDto(savedStamp);
	}
	
	@Test
	public void testCreate() {
		Mockito.when(this.service.create(savedStamp)).thenReturn(stampDto);
		
		assertEquals(stampDto, this.service.create(savedStamp));
		
		Mockito.verify(this.service, Mockito.times(1)).create(savedStamp);
	}
	
	@Test
	public void testRead() {
		List<StampDto> stampList = new ArrayList<StampDto>();
		stampList.add(stampDto);
		
		Mockito.when(this.service.read()).thenReturn(stampList);
		assertFalse(service.read().isEmpty());
		
		Mockito.verify(this.service, Mockito.times(1)).read();
	}
	
	@Test
	public void testReadOne() {
		Mockito.when(this.service.readOne(ID)).thenReturn(stampDto);
		
		assertEquals(stampDto, this.service.readOne(ID)); //not sure if this is correct
		Mockito.verify(this.service, Mockito.times(1)).readOne(ID);
	}
	

	@Test
	public void testUpdate() {
		Stamp newStamp = new Stamp("updated stamp controller", 13.99, 2000);
		
		Stamp stampPlusId = new Stamp(newStamp.getName(), newStamp.getValue(), newStamp.getYearMade());
		stampPlusId.setId(savedStamp.getId());
		
		StampDto stampDtoUpdated = this.service.mapToDto(stampPlusId);
		
		Mockito.when(this.service.update(stampPlusId, savedStamp.getId())).thenReturn(stampDtoUpdated);
		
		assertEquals(stampDtoUpdated, this.service.update(newStamp, savedStamp.getId()));
	}
	
	@Test
	public void testDelete() {
		final boolean RESULT = false;
		assertEquals(RESULT, this.service.delete(ID));
		Mockito.verify(this.service, Mockito.times(1)).delete(ID);
	}
}
