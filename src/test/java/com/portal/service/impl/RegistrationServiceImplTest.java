package com.portal.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.portal.bean.User;
import com.portal.bean.builder.UserBuilder;
import com.portal.dao.UserDAO;
import com.portal.exception.DAOException;

public class RegistrationServiceImplTest {

	RegistrationServiceImpl registrationService;
	
	@Mock
	UserDAO mockUserDAO;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		registrationService = new RegistrationServiceImpl();
		registrationService.setUserDAO(mockUserDAO);
	}
	
	@Test
	public void testRegistrationService_happyPath() {
		User user = new UserBuilder().build();
		Mockito.when(mockUserDAO.create(Mockito.any(User.class))).thenReturn(user);
		registrationService.createUser(user);
		
		Mockito.verify(mockUserDAO, Mockito.atLeastOnce()).create(user);
	}
	
	@Test(expected = DAOException.class)
	public void testRegistrationService_expection() {
		User user = new UserBuilder().build();
		Mockito.when(mockUserDAO.create(Mockito.any(User.class))).thenThrow(new DAOException(""));
		registrationService.createUser(user);
	}
}