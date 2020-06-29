package com.qa.hwa.persistence.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hwa.persistence.domain.Stamp;

@Repository
public interface StampRepo extends JpaRepository<Stamp, Long>{
	
}
