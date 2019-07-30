/**
 * 
 */
package com.vipin.microservice.comsservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author VI852115
 *
 */
@Entity
@Table(name = "BLOG_LIKE_COMMENT_MAPPING")
public class BlogUserMapping implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MAPPING_ID")
	@GeneratedValue//(strategy=GenerationType.SEQUENCE, generator="USER_MASTER_SEQ")
	//@SequenceGenerator(name="USER_MASTER_SEQ", sequenceName="USER_MASTER_SEQ", allocationSize=1)
	private Long mappingId;
	
	@Column(name = "BLOG_ID")
	private Long blogId;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	@Column(name = "LIKED")
	private String liked;
	
	@Column(name = "DISLIKED")
	private String disliked;
	
	@Column(name = "LIKE_DATE")
	private Date likedate;
	
	@Column(name = "COMMENT_DATE")
	private Date commentDate;
	
	@Column(name = "VIEWED")
	private String viewed;

	/*@ManyToOne
	@JoinColumn(name = "BLOG_ID", nullable = false, insertable = false, updatable = false)
	private BlogMaster blogMaster;
	*/
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	private UserMaster userMaster;

	/**
	 * 
	 */
	public BlogUserMapping() {
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * @param blogId
	 * @param userId
	 * @param comments
	 * @param liked
	 * @param disliked
	 * @param likedate
	 * @param commentDate
	 * @param viewed
	 * @param userMaster
	 */
	public BlogUserMapping(Long blogId, Long userId, String comments, String liked, String disliked, Date likedate,
			Date commentDate, String viewed) {
		super();
		this.blogId = blogId;
		this.userId = userId;
		this.comments = comments;
		this.liked = liked;
		this.disliked = disliked;
		this.likedate = likedate;
		this.commentDate = commentDate;
		this.viewed = viewed;
	}



	/**
	 * @return the mappingId
	 */
	public Long getMappingId() {
		return mappingId;
	}

	/**
	 * @param mappingId the mappingId to set
	 */
	public void setMappingId(Long mappingId) {
		this.mappingId = mappingId;
	}

	/**
	 * @return the blogId
	 */
	public Long getBlogId() {
		return blogId;
	}

	/**
	 * @param blogId
	 *            the blogId to set
	 */
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the liked
	 */
	public String getLiked() {
		return liked;
	}

	/**
	 * @param liked
	 *            the liked to set
	 */
	public void setLiked(String liked) {
		this.liked = liked;
	}

	/**
	 * @return the disliked
	 */
	public String getDisliked() {
		return disliked;
	}

	/**
	 * @param disliked
	 *            the disliked to set
	 */
	public void setDisliked(String disliked) {
		this.disliked = disliked;
	}


	/**
	 * @return the likedate
	 */
	public Date getLikedate() {
		return likedate;
	}


	/**
	 * @param likedate the likedate to set
	 */
	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}


	/**
	 * @return the commentDate
	 */
	public Date getCommentDate() {
		return commentDate;
	}


	/**
	 * @param commentDate the commentDate to set
	 */
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the blogMaster
	 */
	/*public BlogMaster getBlogMaster() {
		return blogMaster;
	}

	*//**
	 * @param blogMaster
	 *            the blogMaster to set
	 *//*
	public void setBlogMaster(BlogMaster blogMaster) {
		this.blogMaster = blogMaster;
	}*/

	/**
	 * @return the userMaster
	 */
	public UserMaster getUserMaster() {
		return userMaster;
	}

	/**
	 * @param userMaster
	 *            the userMaster to set
	 */
	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}


	/**
	 * @return the viewed
	 */
	public String getViewed() {
		return viewed;
	}


	/**
	 * @param viewed the viewed to set
	 */
	public void setViewed(String viewed) {
		this.viewed = viewed;
	}

	
	
	
}
