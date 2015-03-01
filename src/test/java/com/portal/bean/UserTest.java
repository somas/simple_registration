package com.portal.bean;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.portal.bean.builder.UserBuilder;

public class UserTest {

	private Validator validator;

	@Before
	public void init() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		this.validator = vf.getValidator();
	}
	
	@Test
	public void testUsername_valid() {
		String[] validUsernames = new String[] {"somas", "SOMAS", "somas123", "s123omas"};
		
		for(String each: validUsernames) {
			User user = new UserBuilder().withUsername(each).build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue(userViolations.isEmpty());
		}
	}
	
	@Test
	public void testUsername_invalid() {
			User user = new UserBuilder().withUsername("").build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue("pattern's size violation", userViolations.size() == 1);
	}
	
	@Test
	public void testUsername_invalid1() {
			User user = new UserBuilder().withUsername(null).build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue("null violation", userViolations.size() == 1);
	}
	
	@Test
	public void testUsername_invalid2() {
		String[] inValidUsernames = new String[] {"somas_", "so-mas"};
		for(String each: inValidUsernames) {
			User user = new UserBuilder().withUsername(each).build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue("pattern violation", userViolations.size() == 1);
		}
	}
	
	@Test
	public void testUsername_invalid3() {
		String[] inValidUsernames = new String[] {"som", "s", "soma"};
		for(String each: inValidUsernames) {
			User user = new UserBuilder().withUsername(each).build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue("size violation", userViolations.size() == 1);
		}
	}
	
	@Test
	public void testPassword_valid() {
		String[] validPassword = new String[] {"abcD1234", "1234aDaD", "aDmDakLL6", "0O0O0O0Oo"};
		
		for(String each: validPassword) {
			User user = new UserBuilder().withPassword(each).build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue(userViolations.isEmpty());
		}
	}
	
	@Test
	public void testPassword_invalid() {
		String[] validPassword = new String[] {"abc1234o", "1234DDDD", "aDmDakLL", "0O0O0O0O"};
		
		for(String each: validPassword) {
			User user = new UserBuilder().withPassword(each).build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue("pattern violation", userViolations.size() == 1);
		}
	}
	
	@Test
	public void testPassword_invalid2() {
		String[] validPassword = new String[] {"abc123O", "1234DdD", "aDmDa1L", "0O0OoO"};
		
		for(String each: validPassword) {
			User user = new UserBuilder().withPassword(each).build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue("pattern violation triggered by size", userViolations.size() == 1);
		}
	}
	
	@Test
	public void testPassword_invalid3() {
			User user = new UserBuilder().withPassword("123abcDD99i23902kln2b32lasmdafhdfosiu1123ln3h1b2gv13c2saokdsmfdfndfb").build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue("exceeds max value", userViolations.size() == 1);
	}
	
	@Test
	public void testEmail_valid() {
			User user = new UserBuilder().withEmail("abc@example.com").build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue(userViolations.isEmpty());
	}
	
	@Test
	public void testEmail_notBlank() {
			User user = new UserBuilder().withEmail("").build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue("not blank", userViolations.size() == 1);
	}
	
	@Test
	public void testEmail_notMatchingVerifyEmail() {
			User user = new UserBuilder().withVerifyEmail("abc@example.com").build();
			Set<ConstraintViolation<User>> userViolations = validator.validate(user);
			
			Assert.assertTrue("not matchin", userViolations.size() == 1);
	}
}
