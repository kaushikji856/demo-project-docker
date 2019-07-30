/**
 * 
 */
package com.vipin.microservice.comsservice.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vipin.microservice.comsservice.model.PostUserMapping;

/**
 * @author VI852115
 *
 */
public interface PostUserMappingRepository extends JpaRepository<PostUserMapping, Long>{
	
	@Query("select count(e.liked), count(e.liked) from PostUserMapping e where e.postId = :postid and e.liked = 'Y'")
	List<Object[]> countByLiked(@Param("postid") long postid);
	
	
	@Query("select count(e.comments), count(e.comments) from PostUserMapping e where e.postId = :postid and e.comments != '' and e.comments != null")
	List<Object[]> countByComments(@Param("postid") long postid);
	
	@Query("select e from PostUserMapping e where e.postId = :postid and e.comments != '' and e.comments != null order by e.commentDate desc")
	List<PostUserMapping> findByPostIdOrderByCommentDateDesc1(@Param("postid") long postid);

}
