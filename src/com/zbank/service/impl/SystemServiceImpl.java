package com.zbank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zbank.dao.System.SystemMapper;
import com.zbank.model.System;
import com.zbank.service.SystemService;

@Service(value="systemService")
@Transactional
public class SystemServiceImpl implements SystemService{
	@Autowired
	private SystemMapper SystemMapper;

	@Override
	public List<System> systemList(int limit, int offset) {
		List<System> systemlist=SystemMapper.systemInfoList(limit, offset);
		return systemlist;
	}

	@Override
	public int systemCout() {
		int systemCout=SystemMapper.systemCount();
		return systemCout;
	}
	@Override
	public int addSystem(System system) {
		int insertFlag=SystemMapper.insert(system);
		return insertFlag;
	}

	@Override
	public int updateSystem(System system) {
		int updateFlag=SystemMapper.insert(system);
		return updateFlag;
	}

	@Override
	public int deleteSystem(String systemEnname) {
		int deleteFlag=SystemMapper.deleteByPrimaryKey(systemEnname);
		return deleteFlag;
	}

}
