package com.portal.dao.impl;

import org.springframework.stereotype.Component;

import com.portal.bean.User;
import com.portal.dao.UserDAO;

@Component
public class JpaUserDAOImpl extends JpaDAO<User> implements UserDAO {

	public JpaUserDAOImpl() {
		super(User.class);
	}

}
