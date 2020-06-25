package com.qa.hwa.persistence.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.hwa.persistence.domain.Stamp;

public interface StampRepo extends JpaRepository<Stamp, Long>{
	
}
