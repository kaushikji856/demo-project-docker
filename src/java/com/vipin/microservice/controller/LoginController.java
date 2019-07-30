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
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.vipin.microservice.comsservice.model.LoginInfo;
import com.vipin.microservice.comsservice.model.UserMaster;
import com.vipin.microservice.comsservice.repsitory.LoginInfoRepository;
import com.vipin.microservice.comsservice.repsitory.UserMasterRepository;

/**
 * @author VI852115
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserMasterRepository userMasterRepository;
	
	@Autowired
	private LoginInfoRepository loginInfoRepo;
	
	@RequestMapping("/")
	public ModelAndView welcomeLogin() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping("/officialPage")
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView("new");
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView welcomePage() {
		ModelAndView mav = null;
		mav = new ModelAndView("login");
		return mav;
	}
	
	
	@RequestMapping(value = "/landingPage", method = RequestMethod.GET)
	public ModelAndView accountPartnerSearch(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		ModelAndView mav = null;
		UserMaster userMaster = userMasterRepository.findByUserNameAndPassword(username, password);
		if (userMaster != null && userMaster.getUserId() != null) {
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setUserId(userMaster.getUserId());
			loginInfo.setLoginTime(new Date());
			loginInfo.setUserName(username);			
			loginInfoRepo.saveAndFlush(loginInfo);
			mav = new ModelAndView("common");
			mav.addObject("username", userMaster.getUserName());
			mav.addObject("userid", userMaster.getUserId());
		} else {
			mav = new ModelAndView("404");
		}

		return mav;
	}
	
	@RequestMapping(value = "/logoutUser", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String logoutUser(@RequestParam("username") String username) {
		List<LoginInfo> loginInfo = loginInfoRepo.findByUserName(username); 
		loginInfo.get(0).setLogoutTime(new Date());
		loginInfoRepo.saveAndFlush(loginInfo.get(0));
		List<String> listResponse = new ArrayList<>();
		listResponse.add("success");
		return new Gson().toJson(listResponse);
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public @ResponseBody ModelAndView addUser(@RequestParam("username") String userName,
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("location") String location, @RequestParam("profession") String profession) {
		ModelAndView mav = null;
		UserMaster userMaster = new  UserMaster(userName, password, email, location, profession);
		userMasterRepository.saveAndFlush(userMaster);
		mav = new ModelAndView("login");
		mav.addObject("msg", "SignuUp successfully,please login with your credentials..");
		return mav;
	}

}
