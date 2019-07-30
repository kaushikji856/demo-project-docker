/**
 * 
 */
package com.vipin.microservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.vipin.microservice.comsservice.model.PostUserMapping;
import com.vipin.microservice.comsservice.model.StatusDto;
import com.vipin.microservice.comsservice.model.UploadFile;
import com.vipin.microservice.comsservice.model.UserMaster;
import com.vipin.microservice.comsservice.repsitory.PostUserMappingRepository;
import com.vipin.microservice.comsservice.repsitory.UploadFileRepository;
import com.vipin.microservice.comsservice.repsitory.UserMasterRepository;

/**
 * @author VI852115
 *
 */

@RestController
public class PostUploadController {
	
	private static final Logger log = Logger.getLogger(BlogController.class);
	
	@Autowired
	UserMasterRepository userMasterRepo;
	@Autowired
	UploadFileRepository uploadFileRepo;
	@Autowired
	PostUserMappingRepository postUserMappingRepo;

	

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST, produces = "application/json")
	public String handleFileUpload(@RequestParam("user_id") String userId, MultipartHttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Iterator<String> iterator = request.getFileNames();
		while (iterator.hasNext()) {
			MultipartFile uploadFileObj = request.getFile(iterator.next());
			UploadFile uploadFile = new  UploadFile(uploadFileObj.getOriginalFilename(),uploadFileObj.getBytes(),	new Long(userId), new Date(), uploadFileObj.getContentType());
			uploadFileRepo.saveAndFlush(uploadFile);
						}
		return new Gson().toJson("success");
	}
	
	@RequestMapping(value = "/getAllPost", method = RequestMethod.GET, produces = "application/json")
	    public String handleFileUpload(@RequestParam("user_id") String userId,@RequestParam("minVal") String minVal,@RequestParam("maxVal") String maxVal) throws Exception {
			List<UploadFile> uploadFilesList = uploadFileRepo.findByUploadedByOrderByUploadedTimeDesc(new Long(userId));
			if(uploadFilesList != null) {
				for (int i=0; i < uploadFilesList.size(); i++) {
					List<Object[]> list = postUserMappingRepo.countByLiked(uploadFilesList.get(i).getPostId());
					List<Object[]> list1 = postUserMappingRepo.countByComments(uploadFilesList.get(i).getPostId());
					if(list != null) {
						uploadFilesList.get(i).setLikeCount(list.get(0)[0].toString());
						uploadFilesList.get(i).setCommentCount(list1.get(0)[0].toString());
					}
				}
			}
		 return new Gson().toJson(uploadFilesList);
	 }
	
	@RequestMapping(value = "/addLikeCommentPost", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String addLikeCommentPost(@RequestParam("postid") String postid,
			@RequestParam("userid") String userid, @RequestParam("comment") String comment,
			@RequestParam("clicktype") String clicktype) {
		List<PostUserMapping> likeCommentList  = null;
		try {
			String comments = "like_clicked".equalsIgnoreCase(clicktype) ? "" : comment;
			String liked =  "like_clicked".equalsIgnoreCase(clicktype) ? "Y" : "";
			Date likedDate =  "like_clicked".equalsIgnoreCase(clicktype) ? new Date() : null;
			Date commentDate = "like_clicked".equalsIgnoreCase(clicktype) ? null : new Date();
			String viewed = "";
			String disliked = "";
			PostUserMapping postUserMapping = new PostUserMapping(new Long(postid), new Long(userid), comments, liked, disliked, likedDate, commentDate);
			postUserMappingRepo.saveAndFlush(postUserMapping);
			PostUserMapping postUserMappingObj = new PostUserMapping(); 
			likeCommentList = new ArrayList<PostUserMapping>();
			postUserMappingObj.setLikeCount(postUserMappingRepo.countByLiked(new Long(postid)).get(0)[0].toString());
			postUserMappingObj.setCommentCount(postUserMappingRepo.countByComments(new Long(postid)).get(0)[0].toString());
			likeCommentList.add(postUserMappingObj);
		} catch (Exception e) { 
			log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(likeCommentList);
	}
	
	@RequestMapping(value = "/getPostCommentData", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getPostCommentData(@RequestParam("postid") String postid,@RequestParam("userid") String userid) {
		List<PostUserMapping> likeCommentList  = null;
		try {
			likeCommentList  = postUserMappingRepo.findByPostIdOrderByCommentDateDesc1(new Long(postid));
		} catch (Exception e) {
			log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(likeCommentList);
	}
	
	@RequestMapping("/getPostCommentData/{postid}")
	public String addCollege(@PathVariable int postid) {
		List<PostUserMapping> likeCommentList  = null;
		try {
			likeCommentList  = postUserMappingRepo.findByPostIdOrderByCommentDateDesc1(new Long(postid));
		} catch (Exception e) {
			log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		if(likeCommentList.size()==0) {
			return new Gson().toJson("Thre is no record found...");
		}
		return new Gson().toJson(likeCommentList);
}
	
	@RequestMapping(value = "/doUploadProfile", method = RequestMethod.POST, produces = "application/json")
	public String doUploadProfile(@RequestParam("user_id") String userId, MultipartHttpServletRequest request,
			HttpServletResponse response) {
		List<UserMaster> userMasterList  = new ArrayList<>();
		Iterator<String> iterator = request.getFileNames();
		while (iterator.hasNext()) {
			try {
				//userMasterList = loggingAspectDao.uploadFile(request.getFile(iterator.next()), userId);
				UserMaster userMaster = userMasterRepo.findByUserId(new Long(userId));
				userMaster.setProfilePhoto(request.getFile(iterator.next()).getBytes());
				userMaster = userMasterRepo.save(userMaster);
				userMasterList.add(userMaster);
			} catch (IOException e) {
				log.error("Profile pic uploading exception occured in:: "+this.getClass()+"Error is--> "+e);
				e.printStackTrace();
			}
		}
		return new Gson().toJson(userMasterList);
	}
	
	@RequestMapping(value = "/doUploadCover", method = RequestMethod.POST, produces = "application/json")
	public String doUploadCover(@RequestParam("user_id") String userId, MultipartHttpServletRequest request,
			HttpServletResponse response) {
		List<UserMaster> userMasterList  = new ArrayList<>();
		Iterator<String> iterator = request.getFileNames();
		while (iterator.hasNext()) {
			try {
				//userMasterList = loggingAspectDao.uploadFile(request.getFile(iterator.next()), userId);
				UserMaster userMaster = userMasterRepo.findByUserId(new Long(userId));
				userMaster.setCoverPhoto(request.getFile(iterator.next()).getBytes());
				userMaster = userMasterRepo.save(userMaster);
				userMasterList.add(userMaster);
			} catch (IOException e) {
				log.error("Profile pic uploading exception occured in:: "+this.getClass()+"Error is--> "+e);
				e.printStackTrace();
			}
		}
		return new Gson().toJson(userMasterList);
	}
	
	@RequestMapping(value = "/getprofileData", method = RequestMethod.GET, produces = "application/json")
	public String getprofileData(@RequestParam("user_id") String userId) {
		List<UserMaster> userMasterList  = new ArrayList<>();
			try {
				UserMaster userMaster = userMasterRepo.findByUserId(new Long(userId));
				userMasterList.add(userMaster);
			} catch (Exception e) {
				log.error("Profile pic uploading exception occured in:: "+this.getClass()+"Error is--> "+e);
				e.printStackTrace();
			}
		return new Gson().toJson(userMasterList);
	}
	
	@RequestMapping(value = "/getCoverPhoto", method = RequestMethod.GET, produces = "application/json")
	public String getCoverPhoto(@RequestParam("user_id") String userId) {
		List<UserMaster> userMasterList  = new ArrayList<>();
			try {
				UserMaster userMaster = userMasterRepo.findByUserId(new Long(userId));
				userMasterList.add(userMaster);
			} catch (Exception e) {
				log.error("Profile pic uploading exception occured in:: "+this.getClass()+"Error is--> "+e);
				e.printStackTrace();
			}
		return new Gson().toJson(userMasterList);
	}
	
	@RequestMapping(value = "/addSimplePost", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String addSimplePost(@RequestParam("userid") String userid, @RequestParam("post") String comment) {
		StatusDto statusDto  = null;
		try {
			UploadFile  uploadFile = new UploadFile(new Long(userid), new Date(), comment);
			uploadFileRepo.saveAndFlush(uploadFile);
			statusDto = new StatusDto();
			statusDto.setFaultString("");
			statusDto.setStatus("success");
		} catch (Exception e) {
			log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(statusDto);
	}
	
	@RequestMapping(value = "/sharePost", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String sharePost(@RequestParam("post_id") String post_id, @RequestParam("username") String username) {
		StatusDto statusDto  = null;
		try {
			
			UserMaster userMaster = userMasterRepo.findByUserName(username);
			uploadFileRepo.findByUploadedByOrderByUploadedTimeDesc(userMaster.getUserId());
			UploadFile  uploadFile = new UploadFile(new Long(userMaster.getUserId()), new Date(), username);
			uploadFileRepo.saveAndFlush(uploadFile);
			statusDto = new StatusDto();
			statusDto.setFaultString("");
			statusDto.setStatus("success");
		} catch (Exception e) {
			log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(statusDto);
	}
	
}
