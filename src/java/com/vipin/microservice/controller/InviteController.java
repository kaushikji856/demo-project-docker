/**
 * 
 */
package com.vipin.microservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.vipin.microservice.comsservice.model.BlogUserMapping;
import com.vipin.microservice.comsservice.model.FriendRequestMaster;
import com.vipin.microservice.comsservice.model.StatusDto;
import com.vipin.microservice.comsservice.model.UserMaster;
import com.vipin.microservice.comsservice.repsitory.FriendRequestMasterRepository;
import com.vipin.microservice.comsservice.repsitory.UserMasterRepository;

/**
 * @author VI852115
 *
 */
@Controller
public class InviteController {
	
	@Autowired
	FriendRequestMasterRepository friendRequestMasterRepo;
	
	@Autowired
	UserMasterRepository userMasterRepo;
	
	@RequestMapping(value = "/sendInvite", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String addBlog(@RequestParam("sender_user_id") String senderUserId, @RequestParam("receiver_user_id") String recieverUserId) {
		FriendRequestMaster friendRequestMaster = new FriendRequestMaster();
		StatusDto statusDto = new StatusDto();
		try {
			friendRequestMaster.setSenderUserId(new Long(senderUserId));
			friendRequestMaster.setRecieverUserId(new Long(recieverUserId));
			friendRequestMaster.setRequestDate(new Date());
			FriendRequestMaster friendRequestMaster1 =  friendRequestMasterRepo.findByRecieverUserIdAndSenderUserId(new Long(recieverUserId), new Long(senderUserId));
			if(friendRequestMaster1 == null) {				
				friendRequestMasterRepo.saveAndFlush(friendRequestMaster);
				statusDto.setFaultString("");
				statusDto.setStatus("success");
			}else {
				statusDto.setFaultString("");
				statusDto.setStatus("failure");
			}
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(statusDto);
	}
	
	
	
	@RequestMapping(value = "/getAllNotification", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getLikeAndComment(@RequestParam("user_id") String userId) {
		List<Object[]> notificationList  = null;
		try {
			notificationList  = friendRequestMasterRepo.countNotification(new Long(userId));
			notificationList.addAll(friendRequestMasterRepo.countAcceptedRequest(new Long(userId)));
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(notificationList);
	}
	
	@RequestMapping(value = "/getRequestList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getRequestList(@RequestParam("userid") String userid) {
		List<FriendRequestMaster> requestListFinal  = null;
		try {
			List<FriendRequestMaster> requestList  = friendRequestMasterRepo.findByRecieverUserId(new Long(userid));
			if(requestList != null && requestList.size() > 0) {
				 requestListFinal  = new ArrayList<FriendRequestMaster>();
				for (FriendRequestMaster friendRequestMaster : requestList) {
					UserMaster userMaster = userMasterRepo.findByUserId(friendRequestMaster.getSenderUserId());
					friendRequestMaster.setUserMaster(userMaster);
					requestListFinal.add(friendRequestMaster);
				}
			}
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(requestListFinal);
	}
	
	@RequestMapping(value = "/acceptAndRejectRequest", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String acceptAndRejectRequest(@RequestParam("user_id") String userId,@RequestParam("sender_id") String senderId, @RequestParam("req_type") String reqType) {
		List<FriendRequestMaster> notificationList  = null;
		try {
			
			FriendRequestMaster friendRequestMaster  = friendRequestMasterRepo.findByRecieverUserIdAndSenderUserId(new Long(userId), new Long(senderId));
			if("accept".equalsIgnoreCase(reqType)) {
				friendRequestMaster.setAccepted("Y");
				friendRequestMaster.setRejected(null);
			}else {
				friendRequestMaster.setRejected("Y");
				friendRequestMaster.setAccepted(null);
			}
			friendRequestMaster.setAcceptDate(new Date());
			friendRequestMaster.setIsOpened("Y");
			friendRequestMasterRepo.saveAndFlush(friendRequestMaster);
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(notificationList);
	}
	
	
	@RequestMapping(value = "/getNotificationList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getNotificationList(@RequestParam("userid") String userid) {
		List<FriendRequestMaster> requestListFinal  = null;
		try {
			List<FriendRequestMaster> requestList  = friendRequestMasterRepo.findRequestRecieved(new Long(userid));
			if(requestList != null && requestList.size() > 0) {
				 requestListFinal  = new ArrayList<FriendRequestMaster>();
				for (FriendRequestMaster friendRequestMaster : requestList) {
					UserMaster userMaster = userMasterRepo.findByUserId(friendRequestMaster.getRecieverUserId());
					friendRequestMaster.setUserMaster(userMaster);
					requestListFinal.add(friendRequestMaster);
				}
			}
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(requestListFinal);
	}
	

}
