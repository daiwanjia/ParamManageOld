package com.zbank.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zbank.dao.User.UserMapper;
import com.zbank.model.User;
import com.zbank.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper UserMapper;

	@Override
	public User login(String username, String userpwd){
		User user = UserMapper.login(username, userpwd);
		return user;
	}

	@Override
	public String findUserpwdByUsername(String username) {

		return UserMapper.findUserpwdByUsername(username);
	}

	@Override
	public boolean findUserByUsername(String username) {

		return StringUtils.isNotBlank(UserMapper.findUserByUsername(username))?true:false;
	}

}
