package com.zbank.dao.User;

import org.apache.ibatis.annotations.Param;

import com.zbank.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 
     * @param username
     * @return  userpwd
     */
    String findUserpwdByUsername(String username);
    /**
     * 
     * @param username
     * @return userid
     */
    String findUserByUsername(String username);
    User login(@Param("username") String username,@Param("userpwd") String userpwd);
}