/**
 * 
 */
package com.vipin.microservice.comsservice.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vipin.microservice.comsservice.model.UserMaster;

/**
 * @author VI852115
 *
 */
public interface UploadProfileRepository extends JpaRepository<UserMaster, Long>{
	
	UserMaster findByUserId(Long userid);

}
