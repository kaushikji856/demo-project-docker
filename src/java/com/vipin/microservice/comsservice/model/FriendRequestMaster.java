/**
 * 
 */
package com.vipin.microservice.comsservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author VI852115
 *
 */
@Entity
@Table(name = "FRIEND_REQUEST_MASTER")
public class FriendRequestMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1075876388378107038L;

	@Id
	@GeneratedValue//(strategy=GenerationType.SEQUENCE, generator="USER_MASTER_SEQ")
	@Column(name = "MAPPING_ID")
	private Long mappingId;
	
	@Column(name = "SENDER_USER_ID")
	private Long senderUserId;
	
	@Column(name = "RECIEVER_USER_ID")
	private Long recieverUserId;
	
	@Column(name = "ACCEPTED")
	private String accepted;
	
	@Column(name = "REJECTED")
	private String rejected;
	
	@Column(name = "REQUEST_DATE")
	private Date requestDate;
	
	@Column(name = "ACCEPT_DATE")
	private Date acceptDate;
	
	@Column(name = "IS_OPENED")
	private String isOpened;
	
	@Column(name = "USER_ID")
	private Date userId;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	private UserMaster userMaster;
	

	/**
	 * 
	 */
	public FriendRequestMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param senderUserId
	 * @param recieverUserId
	 * @param accepted
	 * @param rejected
	 * @param requestDate
	 * @param acceptDate
	 */
	public FriendRequestMaster(Long senderUserId, Long recieverUserId, String accepted, String rejected,
			Date requestDate, Date acceptDate) {
		super();
		this.senderUserId = senderUserId;
		this.recieverUserId = recieverUserId;
		this.accepted = accepted;
		this.rejected = rejected;
		this.requestDate = requestDate;
		this.acceptDate = acceptDate;
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
	 * @return the senderUserId
	 */
	public Long getSenderUserId() {
		return senderUserId;
	}

	/**
	 * @param senderUserId the senderUserId to set
	 */
	public void setSenderUserId(Long senderUserId) {
		this.senderUserId = senderUserId;
	}

	/**
	 * @return the recieverUserId
	 */
	public Long getRecieverUserId() {
		return recieverUserId;
	}

	/**
	 * @param recieverUserId the recieverUserId to set
	 */
	public void setRecieverUserId(Long recieverUserId) {
		this.recieverUserId = recieverUserId;
	}

	/**
	 * @return the accepted
	 */
	public String getAccepted() {
		return accepted;
	}

	/**
	 * @param accepted the accepted to set
	 */
	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}

	/**
	 * @return the rejected
	 */
	public String getRejected() {
		return rejected;
	}

	/**
	 * @param rejected the rejected to set
	 */
	public void setRejected(String rejected) {
		this.rejected = rejected;
	}

	/**
	 * @return the requestDate
	 */
	public Date getRequestDate() {
		return requestDate;
	}

	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	/**
	 * @return the acceptDate
	 */
	public Date getAcceptDate() {
		return acceptDate;
	}

	/**
	 * @param acceptDate the acceptDate to set
	 */
	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	/**
	 * @return the isOpened
	 */
	public String getIsOpened() {
		return isOpened;
	}

	/**
	 * @param isOpened the isOpened to set
	 */
	public void setIsOpened(String isOpened) {
		this.isOpened = isOpened;
	}

	/**
	 * @return the userMaster
	 */
	public UserMaster getUserMaster() {
		return userMaster;
	}

	/**
	 * @param userMaster the userMaster to set
	 */
	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	/**
	 * @return the userId
	 */
	public Date getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Date userId) {
		this.userId = userId;
	}
	
	
	
	
}
