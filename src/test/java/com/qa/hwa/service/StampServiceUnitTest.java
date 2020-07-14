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

	private final long ID = 1L;

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
		this.stampDto = service.mapToDto(savedStamp);
	}

	@Test
	public void testCreate() {

		Mockito.when(this.repo.save(STAMP)).thenReturn(savedStamp);
		Mockito.when(service.mapToDto(savedStamp)).thenReturn(stampDto);

		StampDto createdStampDto = this.stampDto;

		assertEquals(createdStampDto, service.create(STAMP));

		Mockito.verify(this.repo, Mockito.times(1)).save(STAMP);
	}

	@Test
	public void testRead() {
		List<Stamp> stampList = new ArrayList<Stamp>();

		stampList.add(savedStamp);

		Mockito.when(this.repo.findAll()).thenReturn(stampList);
		Mockito.when(service.mapToDto(savedStamp)).thenReturn(stampDto);

		assertFalse(service.read().isEmpty());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	public void testReadOne() {
		Mockito.when(this.repo.findById(ID)).thenReturn(Optional.of(savedStamp));
		
		Mockito.when(this.service.mapToDto(savedStamp)).thenReturn(stampDto);
		
		assertEquals(stampDto, service.readOne(ID));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(ID);
	}

	@Test
	public void testUpdate() {

		Stamp newStamp = new Stamp("updated stamp", 1.99, 1900);

		Stamp stampPlusId = new Stamp(newStamp.getName(), newStamp.getValue(), newStamp.getYearMade());
		stampPlusId.setId(savedStamp.getId());

		StampDto stampToDtoID = service.mapToDto(stampPlusId);

		Mockito.when(this.repo.findById(savedStamp.getId())).thenReturn(Optional.of(savedStamp));

		Mockito.when(this.service.mapToDto(stampPlusId)).thenReturn(stampToDtoID);
		
		Mockito.when(this.repo.save(stampPlusId)).thenReturn(stampPlusId);

		
		assertEquals(stampToDtoID, this.service.update(newStamp, savedStamp.getId()));

		Mockito.verify(this.repo, Mockito.times(1)).findById(ID);
		Mockito.verify(this.repo, Mockito.times(1)).save(stampPlusId);
	}

	@Test
	public void testDelete() {

		final boolean RESULT = false;

		Mockito.when(this.repo.existsById(ID)).thenReturn(false);

		assertEquals(RESULT, this.service.delete(1L));

		Mockito.verify(this.repo, Mockito.times(1)).existsById(ID);
	}

}
