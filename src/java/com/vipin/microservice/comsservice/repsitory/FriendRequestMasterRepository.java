/**
 * 
 */
package com.vipin.microservice.comsservice.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vipin.microservice.comsservice.model.FriendRequestMaster;

/**
 * @author VI852115
 *
 */
public interface FriendRequestMasterRepository extends JpaRepository<FriendRequestMaster, Long> {
	
	@Query("select count(1) from FriendRequestMaster e where reciever_user_Id = :userid and (e.isOpened is null or e.isOpened = '') ")
	List<Object[]> countNotification(@Param("userid") long userid);
	
	@Query("select e from FriendRequestMaster e where e.recieverUserId = :recieverUserId and (e.accepted is null or e.accepted = '') ")
	List<FriendRequestMaster> findByRecieverUserId(@Param("recieverUserId") Long recieverUserId);
	
	FriendRequestMaster findByRecieverUserIdAndSenderUserId(Long recieverId, Long senderId);
	
	@Query("select e from FriendRequestMaster e where e.senderUserId = :senderUserId and (e.accepted != null or e.accepted != '') and (e.isOpened != null or e.isOpened != '') ")
	List<FriendRequestMaster> findRequestRecieved(@Param("senderUserId") Long senderUserId);
	
	@Query("select count(1) from FriendRequestMaster e where e.senderUserId = :senderUserId and (e.accepted != null or e.accepted != '') and (e.isOpened != null or e.isOpened != '') ")
	List<Object[]> countAcceptedRequest(@Param("senderUserId") Long senderUserId);

}
