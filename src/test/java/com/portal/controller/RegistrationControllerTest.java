package com.portal.controller;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.portal.bean.User;
import com.portal.bean.builder.UserBuilder;
import com.portal.exception.ServerSideException;
import com.portal.service.impl.RegistrationServiceImpl;

public class RegistrationControllerTest {

	RegistrationController registrationController;
	
	@Mock
	RegistrationServiceImpl mockRegistrationService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		
		registrationController = new RegistrationController();
		registrationController.setRegistrationService(mockRegistrationService);
	}
	
	@Test
	public void testGet_success() {
		String registrationPage = registrationController.get();
		Assert.assertNotNull(registrationPage);
		Assert.assertEquals(RegistrationController.REGISTRATION_URL, registrationPage);
	}

	@Test
	public void testCreateUser_success() {
		User user = new UserBuilder().build();
		BindingResult mockBindingResult = Mockito.mock(BindingResult.class);
		
		Mockito.when(mockRegistrationService.createUser(user)).thenReturn(user);
		User user1 = registrationController.createUser(user, mockBindingResult);
	
		Assert.assertNotNull(user1);
		Mockito.verify(mockRegistrationService, Mockito.atLeastOnce()).createUser(user);
	}
	
	@Test(expected = ServerSideException.class)
	public void testCreateUser_badData() {
		User user = new UserBuilder().withEmail("").build();
		BindingResult mockBindingResult = Mockito.mock(BindingResult.class);
		Mockito.when(mockBindingResult.hasErrors()).thenReturn(true);
		
		FieldError mockFieldError = Mockito.mock(FieldError.class);
		Mockito.when(mockFieldError.getCode()).thenReturn("fault");
		
		Mockito.when(mockBindingResult.getFieldErrors()).thenReturn(Arrays.asList(mockFieldError));
		
		Mockito.when(mockRegistrationService.createUser(user)).thenReturn(user);
		registrationController.createUser(user, mockBindingResult);
	}

}

