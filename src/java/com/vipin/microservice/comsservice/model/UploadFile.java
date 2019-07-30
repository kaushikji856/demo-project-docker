/**
 * 
 */
package com.vipin.microservice.comsservice.model;

import java.util.Date;

/**
 * @author VI852115
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "UPLOAD_POST")
public class UploadFile {

	@Id
	@Column(name = "POST_ID")
	@GeneratedValue//(strategy=GenerationType.SEQUENCE, generator="USER_MASTER_SEQ")
	//@SequenceGenerator(name="USER_MASTER_SEQ", sequenceName="USER_MASTER_SEQ", allocationSize=1)
	private long postId;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "FILE_TYPE")
	private String fileType;

	@Column(name = "FILE_DATA")
	private byte[] fileData;

	@Column(name = "UPLOADED_BY")//mapped with usreId
	private Long uploadedBy;

	@Column(name = "UPLOADED_TIME")
	private Date uploadedTime;

	@Column(name = "POST_CONTENT")
	private String postContent;
	
	@Transient
	private String likeCount;
	@Transient
	private String commentCount;
	
	/**
	 * 
	 */
	public UploadFile() {
	}

	

	/**
	 * @param uploadedBy
	 * @param uploadedTime
	 * @param postContent
	 */
	public UploadFile(Long uploadedBy, Date uploadedTime, String postContent) {
		super();
		this.uploadedBy = uploadedBy;
		this.uploadedTime = uploadedTime;
		this.postContent = postContent;
	}



	/**
	 * @param fileName
	 * @param fileData
	 * @param uploadedBy
	 * @param uploadedTime
	 */
	public UploadFile(String fileName, byte[] fileData, Long uploadedBy, Date uploadedTime, String fileType) {
		super();
		this.fileName = fileName;
		this.fileData = fileData;
		this.uploadedBy = uploadedBy;
		this.uploadedTime = uploadedTime;
		this.fileType = fileType;
	}



	/**
	 * @return the postId
	 */
	public long getPostId() {
		return postId;
	}



	/**
	 * @param postId the postId to set
	 */
	public void setPostId(long postId) {
		this.postId = postId;
	}



	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType
	 *            the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the fileData
	 */
	public byte[] getFileData() {
		return fileData;
	}

	/**
	 * @param fileData
	 *            the fileData to set
	 */
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	/**
	 * @return the uploadedBy
	 */
	public Long getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * @param uploadedBy
	 *            the uploadedBy to set
	 */
	public void setUploadedBy(Long uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * @return the uploadedTime
	 */
	public Date getUploadedTime() {
		return uploadedTime;
	}

	/**
	 * @param uploadedTime
	 *            the uploadedTime to set
	 */
	public void setUploadedTime(Date uploadedTime) {
		this.uploadedTime = uploadedTime;
	}



	/**
	 * @return the likeCount
	 */
	public String getLikeCount() {
		return likeCount;
	}



	/**
	 * @param likeCount the likeCount to set
	 */
	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}



	/**
	 * @return the commentCount
	 */
	public String getCommentCount() {
		return commentCount;
	}



	/**
	 * @param commentCount the commentCount to set
	 */
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}



	/**
	 * @return the postContent
	 */
	public String getPostContent() {
		return postContent;
	}



	/**
	 * @param postContent the postContent to set
	 */
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	
	

}