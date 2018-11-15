package com.zbank.service;

import com.zbank.model.Environment;

public interface EnvironmentService {

	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	String queryEnvronmentInfo() throws Exception;
	
	/**
     * 新增环境
     * @param environment
     * @return int
     */
    int insert(Environment environment)throws Exception;
    /**
     * 修改环境信息
     * @param environment
     * @return int
     */
    int updateByPrimaryKey(Environment environment)throws Exception;
    /**
     * 删除环境信息
     * @param environmentId
     * @return
     */
    int deleteByPrimaryKey(String environmentId)throws Exception;
}
