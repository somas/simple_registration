package com.portal.bean.builder;

import java.util.Date;

import com.portal.bean.User;

public class UserBuilder {
		private User user = new User();

		public UserBuilder() {
			user.setId(java.util.UUID.randomUUID().toString());
			user.setUsername("sheldon");
			user.setPassword("bAzz1nga");
			user.setVerifyPassword("bAzz1nga");
			user.setEmail("sheldon@example.com");
			user.setVerifyEmail("sheldon@example.com");
			user.setLastUpdated(new Date());
		}
		
		/**
		 * For non-default builder
		 */
		public UserBuilder withNonDefault() {
			user = new User();
			return this;
		}
		
		public UserBuilder withId(String id) {
			user.setId(id);
			return this;
		}

		public UserBuilder withUsername(String login) {
			user.setUsername(login);
			return this;
		}

		public UserBuilder withPassword(String password) {
			user.setPassword(password);
			user.setVerifyPassword(password);
			return this;
		}
		
		public UserBuilder withVerifyPassword(String password) {
			user.setVerifyPassword(password);
			return this;
		}

		public UserBuilder withLastUpdated(Date lastUpdated) {
			user.setLastUpdated(lastUpdated);
			return this;
		}

		public UserBuilder withEmail(String email) {
			user.setEmail(email);
			user.setVerifyEmail(email);
			return this;
		}
		
		public UserBuilder withVerifyEmail(String email) {
			user.setVerifyEmail(email);
			return this;
		}		
		
		public User build() {
			return user;
		}

}
