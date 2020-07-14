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

import com.qa.hwa.dto.StampCollectionDto;
import com.qa.hwa.persistence.domain.StampCollection;
import com.qa.hwa.persistence.repo.StampCollectionRepo;

@RunWith(MockitoJUnitRunner.class)
public class StampCollectionServiceUnitTest {
	
	private final StampCollection COLLECTION = new StampCollection("Stamp Theme Test Collection", 28.99);

	private StampCollection savedCollection;
	
	private StampCollectionDto collectionDto;
	
	private final long ID = 1L;
	
	@Mock 
	StampCollectionRepo repo;
	
	@Mock
	private ModelMapper mapper;
	
	@InjectMocks
	private StampCollectionService service;
	
	@Before
	public void init() {
		this.savedCollection = new StampCollection(COLLECTION.getTheme(), COLLECTION.getValue());
		this.savedCollection.setId(ID);
		this.collectionDto = service.mapToDto(savedCollection);
	}
	
	@Test
	public void testCreate() {
		Mockito.when(this.repo.save(COLLECTION)).thenReturn(savedCollection);
		Mockito.when(service.mapToDto(savedCollection)).thenReturn(collectionDto);

		StampCollectionDto createdCollectionDto = this.collectionDto;

		assertEquals(createdCollectionDto, service.create(COLLECTION));

		Mockito.verify(this.repo, Mockito.times(1)).save(COLLECTION);
	
	}
	
	@Test
	public void testRead() {
		List<StampCollection> collectionList = new ArrayList<StampCollection>();

		collectionList.add(savedCollection);

		Mockito.when(this.repo.findAll()).thenReturn(collectionList);
		Mockito.when(service.mapToDto(savedCollection)).thenReturn(collectionDto);

		assertFalse(service.read().isEmpty());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void testReadOne() {
		Mockito.when(this.repo.findById(ID)).thenReturn(Optional.of(savedCollection));
		
		Mockito.when(this.service.mapToDto(savedCollection)).thenReturn(collectionDto);
		
		assertEquals(collectionDto, service.readOne(ID));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(ID);
	}
	
	@Test
	public void testUpdate() {

		StampCollection newCollection = new StampCollection("updated collection", 11.99);

		StampCollection colPlusId = new StampCollection(newCollection.getTheme(), newCollection.getValue());
		colPlusId.setId(savedCollection.getId());

		StampCollectionDto colToDtoID = service.mapToDto(colPlusId);

		Mockito.when(this.repo.findById(savedCollection.getId())).thenReturn(Optional.of(savedCollection));

		Mockito.when(this.service.mapToDto(colPlusId)).thenReturn(colToDtoID);
		
		Mockito.when(this.repo.save(colPlusId)).thenReturn(colPlusId);

		
		assertEquals(colToDtoID, this.service.update(newCollection, savedCollection.getId()));

		Mockito.verify(this.repo, Mockito.times(1)).findById(ID);
		Mockito.verify(this.repo, Mockito.times(1)).save(colPlusId);
	}
	
	@Test
	public void testDelete() {

		final boolean RESULT = false;

		Mockito.when(this.repo.existsById(ID)).thenReturn(false);

		assertEquals(RESULT, this.service.delete(1L));

		Mockito.verify(this.repo, Mockito.times(1)).existsById(ID);
	}

	
}
