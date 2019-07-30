/**
 * 
 */
package com.vipin.microservice.comsservice.model;

import java.util.Date;

/**
 * @author VI852115
 *
 */
public class LikeCommentDataDto {

	private String userId;
	private String blogId;
	private String liked;
	private String likedBy;
	private String comment;
	private String commentBy;
	private String likeDate;
	private String commentDate;
	private String userName;
	private String postId;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the blogId
	 */
	public String getBlogId() {
		return blogId;
	}

	/**
	 * @param blogId
	 *            the blogId to set
	 */
	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	/**
	 * @return the likedBy
	 */
	public String getLikedBy() {
		return likedBy;
	}

	/**
	 * @param likedBy
	 *            the likedBy to set
	 */
	public void setLikedBy(String likedBy) {
		this.likedBy = likedBy;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the likeDate
	 */
	public String getLikeDate() {
		return likeDate;
	}

	/**
	 * @param likeDate
	 *            the likeDate to set
	 */
	public void setLikeDate(String likeDate) {
		this.likeDate = likeDate;
	}

	/**
	 * @return the commentDate
	 */
	public String getCommentDate() {
		return commentDate;
	}

	/**
	 * @param commentDate
	 *            the commentDate to set
	 */
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
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
	 * @return the commentBy
	 */
	public String getCommentBy() {
		return commentBy;
	}

	/**
	 * @param commentBy
	 *            the commentBy to set
	 */
	public void setCommentBy(String commentBy) {
		this.commentBy = commentBy;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
