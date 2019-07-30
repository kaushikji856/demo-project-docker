/**
 * 
 */
package com.vipin.microservice.comsservice.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author VI852115
 *
 */
@Entity
@Table(name = "user_master")
public class UserMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue//(strategy=GenerationType.SEQUENCE, generator="USER_MASTER_SEQ")
	//@SequenceGenerator(name="USER_MASTER_SEQ", sequenceName="USER_MASTER_SEQ", allocationSize=1)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_date")
	private Timestamp createdDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "modified_date")
	private Timestamp modifiedDate;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "role_type")
	private String roleType;
	
	@Column(name = "role_id")
	private String roleId;

	@Column(name = "email")
	private String email;
	
	@Lob
	@Column(name = "PROFILE_PHOTO")
	private byte[] profilePhoto;
	
	@Column(name = "USER_LOCATION")
	private String userLocation;
	
	@Column(name = "USER_PROFESSION")
	private String userProfession;
	
	@Lob
	@Column(name = "COVER_PHOTO")
	private byte[] coverPhoto;
	
	/*@OneToMany(mappedBy = "userMaster")
	private Set<AddressBook> addressBookSet = new HashSet<>();
	
	@OneToMany(mappedBy = "userMaster" )
	private Set<BlogMaster> blogMasterSet = new HashSet<>();
	
	@OneToMany(mappedBy = "userMaster")
	private Set<BlogUserMapping> blogUserMappingSet = new HashSet<>();*/
	
	/**
	 * 
	 */
	public UserMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param userName
	 * @param password
	 * @param email
	 */
	public UserMaster(String userName, String password, String email,String location, String profession) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userLocation = location;
		this.userProfession = profession;
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the modifiedDate
	 */
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the roleType
	 */
	public String getRoleType() {
		return roleType;
	}

	/**
	 * @param roleType the roleType to set
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the profilePhoto
	 */
	public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	/**
	 * @param profilePhoto the profilePhoto to set
	 */
	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	/**
	 * @return the userLocation
	 */
	public String getUserLocation() {
		return userLocation;
	}

	/**
	 * @param userLocation the userLocation to set
	 */
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	/**
	 * @return the userProfession
	 */
	public String getUserProfession() {
		return userProfession;
	}

	/**
	 * @param userProfession the userProfession to set
	 */
	public void setUserProfession(String userProfession) {
		this.userProfession = userProfession;
	}

	/**
	 * @return the coverPhoto
	 */
	public byte[] getCoverPhoto() {
		return coverPhoto;
	}

	/**
	 * @param coverPhoto the coverPhoto to set
	 */
	public void setCoverPhoto(byte[] coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	
	
	/**
	 * @return the addressBookSet
	 */
	/*public Set<AddressBook> getAddressBookSet() {
		return addressBookSet;
	}

	*//**
	 * @param addressBookSet the addressBookSet to set
	 *//*
	public void setAddressBookSet(Set<AddressBook> addressBookSet) {
		this.addressBookSet = addressBookSet;
	}

	*//**
	 * @return the blogMasterSet
	 *//*
	public Set<BlogMaster> getBlogMasterSet() {
		return blogMasterSet;
	}

	*//**
	 * @param blogMasterSet the blogMasterSet to set
	 *//*
	public void setBlogMasterSet(Set<BlogMaster> blogMasterSet) {
		this.blogMasterSet = blogMasterSet;
	}

	*//**
	 * @return the blogUserMappingSet
	 *//*
	public Set<BlogUserMapping> getBlogUserMappingSet() {
		return blogUserMappingSet;
	}

	*//**
	 * @param blogUserMappingSet the blogUserMappingSet to set
	 *//*
	public void setBlogUserMappingSet(Set<BlogUserMapping> blogUserMappingSet) {
		this.blogUserMappingSet = blogUserMappingSet;
	}*/

	
	

}
