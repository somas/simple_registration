package com.portal.service.impl;

import java.time.Instant;
import java.util.Date;

import javax.annotation.Resource;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import com.portal.bean.User;
import com.portal.dao.UserDAO;
import com.portal.exception.DuplicateUserException;
import com.portal.service.RegistrationService;

@Component
public class RegistrationServiceImpl implements RegistrationService {
	
	@Resource
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public User createUser(User user) {
		//set timestamp
		Instant now = Instant.now();
		user.setDateCreated(Date.from(now));
		user.setLastUpdated(Date.from(now));
		
		User tempUser;
		try {
			tempUser = userDAO.create(user);
		} catch(PersistenceException e) {
			if (e.getCause() != null && e.getCause() instanceof ConstraintViolationException && 
					((ConstraintViolationException) e.getCause()).getSQLException().getMessage().contains("unique constraint")) {
				throw new DuplicateUserException("Unique Constraint Violated");
			} else {
				throw e;
			}
		}
		return tempUser;
	}

}
