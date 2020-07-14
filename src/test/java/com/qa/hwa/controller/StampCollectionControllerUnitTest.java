package com.qa.hwa.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.hwa.dto.StampCollectionDto;
import com.qa.hwa.persistence.domain.StampCollection;
import com.qa.hwa.persistence.repo.StampCollectionRepo;
import com.qa.hwa.service.StampCollectionService;

@RunWith(MockitoJUnitRunner.class)
public class StampCollectionControllerUnitTest {

	private final StampCollection COLLECTION = new StampCollection("controller collection test", 34.99);

	private final long ID = 1L;

	private StampCollection savedCollection;

	private StampCollectionDto collectionDto;

	@Mock
	private StampCollectionRepo repo;

	@Mock
	private StampCollectionService service;

	@Before
	public void init() {
		this.savedCollection = new StampCollection(COLLECTION.getTheme(), COLLECTION.getValue());
		this.savedCollection.setId(this.ID);
		this.collectionDto = service.mapToDto(savedCollection);
	}

	@Test
	public void testCreate() {
		Mockito.when(this.service.create(savedCollection)).thenReturn(collectionDto);

		assertEquals(collectionDto, this.service.create(savedCollection));

		Mockito.verify(this.service, Mockito.times(1)).create(savedCollection);
	}

	@Test
	public void testRead() {
		List<StampCollectionDto> colList = new ArrayList<StampCollectionDto>();
		colList.add(collectionDto);

		Mockito.when(this.service.read()).thenReturn(colList);
		assertFalse(service.read().isEmpty());

		Mockito.verify(this.service, Mockito.times(1)).read();
	}

	@Test
	public void testReadOne() {
		Mockito.when(this.service.readOne(ID)).thenReturn(collectionDto);

		assertEquals(collectionDto, this.service.readOne(ID));
		Mockito.verify(this.service, Mockito.times(1)).readOne(ID);
	}

	@Test
	public void testUpdate() {
		StampCollection newCollection = new StampCollection("updated colleciton", 15.99);

		StampCollection colPlusId = new StampCollection(COLLECTION.getTheme(), COLLECTION.getValue());
		colPlusId.setId(savedCollection.getId());

		StampCollectionDto colDtoUpdated = this.service.mapToDto(colPlusId);

		assertEquals(colDtoUpdated, this.service.update(newCollection, savedCollection.getId()));
		Mockito.verify(this.service, Mockito.times(1)).update(newCollection, savedCollection.getId());
	}

	@Test
	public void testDelete() {
		final boolean RESULT = false;
		assertEquals(RESULT, this.service.delete(ID));
		Mockito.verify(this.service, Mockito.times(1)).delete(ID);
	}

}
