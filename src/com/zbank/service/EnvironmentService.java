package com.zbank.service;

import java.util.List;

import com.zbank.model.Environment;

public interface EnvironmentService {

	/**
	 * 查询所有
	 * @return
	 * @throws Exception
	 */
	List<Environment> queryEnvronmentInfo() throws Exception;
}
