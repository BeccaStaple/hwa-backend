package com.qa.hwa.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hwa.persistence.domain.StampCollection;

@Repository
public interface StampCollectionRepo extends JpaRepository<StampCollection, Long>{

}
