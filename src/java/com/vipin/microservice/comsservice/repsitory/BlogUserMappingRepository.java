/**
 * 
 */
package com.vipin.microservice.comsservice.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vipin.microservice.comsservice.model.BlogUserMapping;
import com.vipin.microservice.comsservice.model.LikeCommentDataDto;

/**
 * @author VI852115
 *
 */
public interface BlogUserMappingRepository extends JpaRepository<BlogUserMapping, Long>{
	
	List<BlogUserMapping> findByBlogId(long blogid);
	
	@Query("select count(e.liked), count(e.liked) from BlogUserMapping e where e.blogId = :blogid and e.liked = 'Y'")
	List<BlogUserMapping> countByLiked(@Param("blogid") long blogid);
	
	//@Query("select * from BlogUserMapping e, UserMaster f where e.userId = f.userId and e.blogId = :blogid order by commentDate desc")
	List<BlogUserMapping> findByBlogIdOrderByCommentDateDesc(long blogid);
	
	

}
