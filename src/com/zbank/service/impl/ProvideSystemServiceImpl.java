package com.zbank.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zbank.dao.provideSystem.ProvideSystemMapper;
import com.zbank.model.ProvideSystem;
import com.zbank.service.ProvideSystemService;

@Service(value="systemService")
@Transactional
public class ProvideSystemServiceImpl implements ProvideSystemService{
	@Autowired
	private ProvideSystemMapper systemMapper;

	private static Log log = LogFactory.getLog(ProvideSystemServiceImpl.class);
	@Override
	public String systemList(int limit, int offset,String systemEnname,String systemCnname) {
		List<ProvideSystem> systemlist=systemMapper.systemInfoList(limit, offset,systemEnname,systemCnname);
		//查询分页数据
		JSONArray systemArray=JSONArray.parseArray(systemlist.toString());
		JSONObject jsonObject = new JSONObject();
		// 查询数据总量
		jsonObject.put("count",systemMapper.systemCount(systemEnname,systemCnname));
		jsonObject.put("data", systemArray);
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		if(log.isDebugEnabled()){
			log.debug("provideSystemInfo===" + jsonObject.toJSONString());
		}	
		return jsonObject.toJSONString();
	}

	@Override
	public int addSystem(ProvideSystem system) {
		int insertFlag=systemMapper.insert(system);
		return insertFlag;
	}

	@Override
	public int updateSystem(ProvideSystem system) {
		int updateFlag=systemMapper.updateByPrimaryKey(system);
		return updateFlag;
	}

	@Override
	public int deleteSystem(String systemEnname) {
		int deleteFlag=systemMapper.deleteByPrimaryKey(systemEnname);
		return deleteFlag;
	}

	@Override
	public List<ProvideSystem> allSystem() {
		
		return systemMapper.querySystemAll();
	}

}
