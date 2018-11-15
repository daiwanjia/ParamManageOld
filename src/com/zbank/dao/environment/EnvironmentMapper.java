package com.zbank.dao.environment;

import java.util.List;

import com.zbank.model.Environment;

public interface EnvironmentMapper {

	int insert(Environment environment);

    Environment selectByPrimaryKey(String environmentId);

    int updateByPrimaryKeySelective(Environment record);

    /**
     * 查询环境信息 all
     * @return list
     */
    List<Environment> queryEnvironmentInfo();
    
    /**
     * 查询环境总量
     * @return
     */
    int queryEnvironmentInfoCount();
    
    /**
     * 新增环境
     * @param environment
     * @return int
     */
    int insertSelective(Environment environment);
   
    /**
     * 修改环境信息
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Environment environment);
    /**
     * 删除环境信息
     * @param environmentId
     * @return
     */
    int deleteByPrimaryKey(String environmentId);
}