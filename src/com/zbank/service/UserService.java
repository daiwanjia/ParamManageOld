package com.zbank.service;

import com.zbank.model.User;

public interface UserService {
	User login(String username,String userpwd);
	 /**
     * 查用户名对应的密码
     * @param username
     * @return  userpwd
     */
    String findUserpwdByUsername(String username);
    /**
     * 查用户是否存在
     * @param username
     * @return userid
     */
    boolean findUserByUsername(String username);
}
