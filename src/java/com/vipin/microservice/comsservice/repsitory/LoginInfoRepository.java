/**
 * 
 */
package com.vipin.microservice.comsservice.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vipin.microservice.comsservice.model.LoginInfo;

/**
 * @author VI852115
 *
 */
public interface LoginInfoRepository extends JpaRepository<LoginInfo, Long>{
	
	@Query("select distinct e.userName, e.userId from LoginInfo e where userId != :userid and logoutTime is null")
	List<Object[]> getOnlineFriends(@Param("userid") Long userid);
	
	@Query("select e from LoginInfo e where e.userName != :username and e.logoutTime is null")
	List<LoginInfo> findByUserName(@Param ("username")String username);

}
