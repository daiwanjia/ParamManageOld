package com.zbank.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zbank.dao.service.ServiceMapper;
import com.zbank.model.Service;
import com.zbank.service.ServiceService;

@Transactional
@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceMapper serviceMapper;

	private static Log log = LogFactory.getLog(ServiceServiceImpl.class);

	@Override
	public int insertService(Service service) throws Exception {

		return serviceMapper.insertService(service);
	}

	@Override
	public int uadateByPrimaryKey(Service service) throws Exception {

		return serviceMapper.updateByPrimaryKey(service);
	}

	@Override
	public int deleteByPrimaryKey(String serviceId) throws Exception {

		return serviceMapper.deleteByPrimaryKey(serviceId);
	}

	@Override
	public String serviceList(int limit, int offset, String serviceEnname, String serviceCnname, String serviceSystem,
			String serviceStatus) throws Exception {
		List<Service> list = serviceMapper.serviceList(limit, offset, serviceEnname, serviceCnname, serviceSystem,serviceStatus);
		//查询分页数据
		JSONArray serviceArray=JSONArray.parseArray(list.toString());
		JSONObject jsonObject = new JSONObject();
		// 查询数据总量
		jsonObject.put("count",serviceMapper.seriveCount(limit, offset, serviceEnname, serviceCnname, serviceSystem, serviceStatus));
		jsonObject.put("data", serviceArray);
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		if(log.isDebugEnabled()){
			log.debug("serviceInfo===" + jsonObject.toJSONString());
		}	
		return jsonObject.toJSONString();
	}

}
