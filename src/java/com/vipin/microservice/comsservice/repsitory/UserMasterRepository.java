/**
 * 
 */
package com.vipin.microservice.comsservice.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vipin.microservice.comsservice.model.LoginInfo;
import com.vipin.microservice.comsservice.model.UserMaster;

/**
 * @author VI852115
 *
 */
public interface UserMasterRepository extends JpaRepository<UserMaster, Long>{
	
	List<UserMaster> findAll();
	UserMaster findByUserNameAndPassword(String userName, String password);
	UserMaster findByUserName(String useName);
	UserMaster findByUserId(Long userid);
	List<UserMaster> findByUserNameIgnoreCaseContaining(String username);

}
