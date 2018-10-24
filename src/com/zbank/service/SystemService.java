package com.zbank.service;

import java.util.List;

import com.zbank.model.System;

public interface SystemService {
	/**
	 * 分页查询系统信息
	 * @param limit
	 * @param offset
	 * @param systemEnname
	 * @param systenCnname
	 * @return systemList
	 */
	List<System> systemList(int limit,int offset,String systemEnname,String systemCnname);
	/**
	 * 分页查询数据总量
	 * @param systemEnname
	 * @param systemCnname
	 * @return
	 */
	int systemCout(String systemEnname,String systemCnname);
	/**
	 * 新增系统信息
	 * @param system
	 * @return int
	 */
	int addSystem(System system);
	/**
	 * 修改系统信息
	 * @param system
	 * @return int
	 */
	int updateSystem(System system);
	/**
	 * 删除系统
	 * @param systemEnname
	 * @return int
	 */
	int deleteSystem(String systemEnname);
}
