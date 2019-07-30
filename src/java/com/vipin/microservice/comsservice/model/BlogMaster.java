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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author VI852115
 *
 */
@Entity
@Table(name = "BLOG_MASTER")
public class BlogMaster implements Serializable {
	
	@Id
	@Column(name = "BLOG_ID")
	@GeneratedValue//(strategy=GenerationType.SEQUENCE, generator="USER_MASTER_SEQ")
	//@SequenceGenerator(name="USER_MASTER_SEQ", sequenceName="USER_MASTER_SEQ", allocationSize=1)	
	private Long blogId;
	
	@Column(name = "BLOG_TITTLE")
	private String blogTittle;
	
	@Column(name = "BLOG_NAME")
	private String blogName;
	
	@Column(name = "BLOG_CONTENT")
	private String blogContent;
	
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	/*@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	private UserMaster userMaster;
	
	@OneToMany(mappedBy = "blogMaster")
	private Set<BlogUserMapping> blogUserMappingsets = new HashSet<>();*/
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BlogMaster() {
	}

	/**
	 * @return the blogId
	 */
	public Long getBlogId() {
		return blogId;
	}

	/**
	 * @param blogId the blogId to set
	 */
	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	/**
	 * @return the blogTittle
	 */
	public String getBlogTittle() {
		return blogTittle;
	}

	/**
	 * @param blogTittle the blogTittle to set
	 */
	public void setBlogTittle(String blogTittle) {
		this.blogTittle = blogTittle;
	}

	/**
	 * @return the blogName
	 */
	public String getBlogName() {
		return blogName;
	}

	/**
	 * @param blogName the blogName to set
	 */
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	/**
	 * @return the blogContent
	 */
	public String getBlogContent() {
		return blogContent;
	}

	/**
	 * @param blogContent the blogContent to set
	 */
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	

	/**
	 * @return the blogUserMappingsets
	 *//*
	public Set<BlogUserMapping> getBlogUserMappingsets() {
		return blogUserMappingsets;
	}

	*//**
	 * @param blogUserMappingsets the blogUserMappingsets to set
	 *//*
	public void setBlogUserMappingsets(Set<BlogUserMapping> blogUserMappingsets) {
		this.blogUserMappingsets = blogUserMappingsets;
	}

	*//**
	 * @return the userMaster
	 *//*
	public UserMaster getUserMaster() {
		return userMaster;
	}

	*//**
	 * @param userMaster the userMaster to set
	 *//*
	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}*/

	
	
}
