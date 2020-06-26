package com.qa.hwa.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.hwa.persistence.domain.Stamp;
import com.qa.hwa.persistence.repo.StampRepo;

@RunWith(MockitoJUnitRunner.class)
public class StampServiceUnitTest {

	private final Stamp STAMP = new Stamp("star", 1.11, 1996);
	
	private Stamp savedStamp;
	
	@Mock
	private StampRepo repo;
	
	@InjectMocks
	private StampService service;
	
	@Before
	public void init() {
		this.savedStamp = new Stamp(STAMP.getName(), STAMP.getValue(), STAMP.getYearMade());
		this.savedStamp.setId(1L);
	}
	
	@Test
	public void testCreate() {
		Mockito.when(this.repo.save(STAMP)).thenReturn(savedStamp);
		
		assertEquals(savedStamp, service.create(STAMP));
		
		Mockito.verify(this.repo, Mockito.times(1)).save(STAMP);
	}
	
}
