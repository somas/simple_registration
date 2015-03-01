package com.portal.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portal.bean.ServerSideError;
import com.portal.bean.ServerSideErrors;
import com.portal.bean.User;
import com.portal.exception.DuplicateUserException;
import com.portal.exception.ServerSideException;
import com.portal.service.RegistrationService;
import com.portal.service.impl.RegistrationServiceImpl;
import com.portal.util.FaultUtils;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	private static Logger logger = Logger.getLogger(RegistrationController.class);
	public static final String REGISTRATION_URL = "/registration/join.jsp";
	
	@Autowired
	private RegistrationService registrationService;
	

	public void setRegistrationService(RegistrationServiceImpl registrationService) {
		this.registrationService = registrationService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return REGISTRATION_URL;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody User createUser(@Valid User user, BindingResult bindingResult) {
		
		ServerSideErrors errorColl = new ServerSideErrors();
		
		if(FaultUtils.checkForViolations(false, bindingResult, errorColl)) {
			ServerSideError error = new ServerSideError.Builder().id("ssGeneralError").message("Both Item key and Field key are required").build();
			throw new ServerSideException(errorColl.add(error));
		}

		// write to DB
		try {
			user.setId(java.util.UUID.randomUUID().toString());
			registrationService.createUser(user);
		} catch (DuplicateUserException e) {
			logger.error(e);
			ServerSideError error = new ServerSideError.Builder().id("ssGeneralError").message("Username taken, please select a different one.").build();
			throw new ServerSideException(errorColl.add(error));
		} catch(Exception e) {
			logger.error(e);
			ServerSideError error = new ServerSideError.Builder().id("ssGeneralError").message("Error creating User, please try again. If persists, please contact support").build();
			throw new ServerSideException(errorColl.add(error));
		}
		
		return user;
	}

	
}
