package com.zbank.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zbank.dao.environment.EnvironmentMapper;
import com.zbank.model.Environment;
import com.zbank.service.EnvironmentService;

@Service
@Transactional
public class EnvironmentServiceImpl implements EnvironmentService{

	@Autowired
	private EnvironmentMapper environmentMapper;
	@Override
	public List<Environment> queryEnvronmentInfo() throws Exception {
		List<Environment> environmentList=environmentMapper.queryEnvironmentInfo();
		return environmentList;
	}

}
