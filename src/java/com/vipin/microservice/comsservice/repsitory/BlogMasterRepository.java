package com.vipin.microservice.comsservice.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vipin.microservice.comsservice.model.BlogMaster;

/**
 * @author VI852115
 *
 */
public interface BlogMasterRepository extends JpaRepository<BlogMaster, Long>{
	
	List<BlogMaster> findByUserId(long userId);
	List<BlogMaster> findTop20ByOrderByCreatedDate();

}
