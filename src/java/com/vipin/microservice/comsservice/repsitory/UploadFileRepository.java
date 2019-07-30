/**
 * 
 */
package com.vipin.microservice.comsservice.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vipin.microservice.comsservice.model.UploadFile;

/**
 * @author VI852115
 *
 */
public interface UploadFileRepository extends JpaRepository<UploadFile, Long>{
	
	List<UploadFile> findByUploadedByOrderByUploadedTimeDesc(Long userId);
	//List<UploadFile> findByPostId();

}
