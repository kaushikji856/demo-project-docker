/**
 * 
 */
package com.vipin.microservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vipin.microservice.comsservice.model.UserMaster;
import com.vipin.microservice.comsservice.repsitory.UserMasterRepository;

/**
 * @author VI852115
 *
 */
@RestController
public class ComsController {

	//@Autowired
	//private ComsDBServiceRepository comsDBServiceRepository;
	
	@Autowired
	private UserMasterRepository userMasterRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	/*@RequestMapping("/rest/coms/gettransaction/{transactionid}")
    public List<TransactionStatus> getTransactionData(@PathVariable("transactionid") final String transactionid) {
		 List<TransactionStatus> transactionStatusList = new ArrayList<>();
		//comsDBServiceRepository.findByMsisdn(new Long("1799165746"));
		//comsDBServiceRepository.findByTask("QUERY_PROFILE");
		 //transactionStatusList = null;//comsDBServiceRepository.findTop10ByMsisdnOrderByCreateDateDesc(new Long("1799165746"));
		 transactionStatusList.add(new TransactionStatus());
		 
		 
		 
		// ResponseEntity<List<String>> quoteResponse = restTemplate.exchange("http://localhost:8761/Spring-Boot-Project/getLatestBlogs", HttpMethod.GET, null, null, null);
		 
		// if(quoteResponse.getBody().get(0).getBytes().equals("")) {
			 
		 //}
		 
        return transactionStatusList;
    }*/
	
	@RequestMapping("/rest/getuserdata/{userid}")
    public List<UserMaster> getUserMasterData(@PathVariable("userid") final String userid) {
		 List<UserMaster> usermasterList = new ArrayList<>();
		 usermasterList = userMasterRepository.findAll();
        return usermasterList;
    }
}
