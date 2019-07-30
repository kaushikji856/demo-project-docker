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
import com.vipin.microservice.comsservice.model.BlogMaster;
import com.vipin.microservice.comsservice.model.BlogUserMapping;
import com.vipin.microservice.comsservice.model.LoginInfo;
import com.vipin.microservice.comsservice.model.StatusDto;
import com.vipin.microservice.comsservice.model.UserMaster;
import com.vipin.microservice.comsservice.repsitory.BlogMasterRepository;
import com.vipin.microservice.comsservice.repsitory.BlogUserMappingRepository;
import com.vipin.microservice.comsservice.repsitory.LoginInfoRepository;
import com.vipin.microservice.comsservice.repsitory.UserMasterRepository;

/**
 * @author VI852115
 *
 */
@Controller
public class BlogController {
	
	@Autowired
	BlogMasterRepository blogMasterRepo;
	
	@Autowired
	BlogUserMappingRepository blogUserMappingRepo;
	
	@Autowired
	UserMasterRepository userMasterRepo;
	
	@Autowired
	LoginInfoRepository loginInfoRepo;

	@RequestMapping(value = "/getUserBlog", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getUserBlog(@RequestParam("user_id") String userid) {
		List<BlogMaster> blogMastersList  = null;
		List<BlogMaster> listResponse = new ArrayList<>();
		try {
			blogMastersList  = blogMasterRepo.findByUserId(new Long(userid));
			if(blogMastersList != null) {
				for (BlogMaster blogMaster : blogMastersList) {
					BlogMaster blogModel = new BlogMaster();
					blogModel.setBlogTittle(blogMaster.getBlogTittle());
					blogModel.setBlogId(blogMaster.getBlogId());
					blogModel.setBlogName(blogMaster.getBlogName()); 
					blogModel.setBlogContent(blogMaster.getBlogContent());
					blogModel.setCreatedDate(blogMaster.getCreatedDate());
					blogModel.setUserId(blogMaster.getUserId());
					listResponse.add(blogModel); 
				}
			}
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(listResponse);
	}
	
	@RequestMapping(value = "/getLatestBlogs", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getLaestBlogs() {
		List<BlogMaster> blogMastersList  = null;
		List<BlogMaster> listResponse = new ArrayList<>();
		try {
			blogMastersList  = blogMasterRepo.findTop20ByOrderByCreatedDate();
			if(blogMastersList != null) { 
				for (BlogMaster blogMaster : blogMastersList) {
					BlogMaster blogModel = new BlogMaster();
					blogModel.setBlogTittle(blogMaster.getBlogTittle());
					blogModel.setBlogId(blogMaster.getBlogId());
					blogModel.setBlogName(blogMaster.getBlogName()); 
					blogModel.setBlogContent(blogMaster.getBlogContent());
					blogModel.setCreatedDate(blogMaster.getCreatedDate());
					blogModel.setUserId(blogMaster.getUserId());
					listResponse.add(blogModel); 
				}
			}
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(listResponse);
	}
	
	@RequestMapping(value = "/addBlog", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String addBlog(@RequestParam("tittle") String tittle,
			@RequestParam("name") String name, @RequestParam("content") String content, @RequestParam("user_id") String user_id) {
		BlogMaster blogDto = new BlogMaster();
		try {
		blogDto.setBlogTittle(tittle);
		blogDto.setBlogName(name);
		blogDto.setBlogContent(content);
		blogDto.setCreatedDate(new Date());
		blogDto.setUserId(new Long(user_id));
		blogMasterRepo.saveAndFlush(blogDto);
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		StatusDto statusDto = new StatusDto();
		statusDto.setFaultString("");
		statusDto.setStatus("success");
		return new Gson().toJson(statusDto);
	}
	
	@RequestMapping(value = "/addLike", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String addLike(@RequestParam("blogid") String blogid,
			@RequestParam("userid") String userid, @RequestParam("comment") String comment,
			@RequestParam("clicktype") String clicktype) {
		List<BlogUserMapping> likeCommentList  = null;
		try {
			String comments = "like_clicked".equalsIgnoreCase(clicktype) ? "" : comment;
			String liked =  "like_clicked".equalsIgnoreCase(clicktype) ? "Y" : "";
			Date likedDate =  "like_clicked".equalsIgnoreCase(clicktype) ? new Date() : null;
			Date commentDate = "like_clicked".equalsIgnoreCase(clicktype) ? null : new Date();
			String viewed = "";
			String disliked = "";
			BlogUserMapping blogUserMapping = new BlogUserMapping(new Long(blogid), new Long(userid), comments, liked, disliked, likedDate, commentDate, viewed);
			blogUserMappingRepo.saveAndFlush(blogUserMapping);
			likeCommentList = blogUserMappingRepo.countByLiked(new Long(blogid));
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(likeCommentList);
	}
	
	@RequestMapping(value = "/getLikeAndComment", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getLikeAndComment(@RequestParam("blogid") String blogId,@RequestParam("user_id") String userId) {
		List<BlogUserMapping> likeCommentList  = null;
		try {
			likeCommentList  = blogUserMappingRepo.countByLiked(new Long(blogId));
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(likeCommentList);
	}
	
	
	@RequestMapping(value = "/getLikeCommentData", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getLikeCommentData(@RequestParam("blogid") String blogid,@RequestParam("userid") String userid) {
		List<BlogUserMapping> likeCommentList  = null;
		try {
			likeCommentList  = blogUserMappingRepo.findByBlogIdOrderByCommentDateDesc(new Long(blogid));
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(likeCommentList);
	}
	
	@RequestMapping(value = "/getOnlineFriends", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getOnlineFriends(@RequestParam("user_id") String userid) {
		List<Object[]> likeCommentList  = null;
		try {
			likeCommentList  = loginInfoRepo.getOnlineFriends(new Long(userid));  
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(likeCommentList);
	}
	@RequestMapping(value = "/searchFriends", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String searchFriends(@RequestParam("filter") String filterStr) {
		List<UserMaster> searchFriendList  = null;
		try {
			searchFriendList  = userMasterRepo.findByUserNameIgnoreCaseContaining(filterStr);
		} catch (Exception e) {
			//log.error("Exception occured in:: "+this.getClass()+"Error is--> "+e);
		}
		return new Gson().toJson(searchFriendList);
	}
}
