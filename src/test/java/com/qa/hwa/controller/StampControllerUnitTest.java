package com.qa.hwa.controller;

import static org.junit.Assert.assertEquals;

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
	
	
}
