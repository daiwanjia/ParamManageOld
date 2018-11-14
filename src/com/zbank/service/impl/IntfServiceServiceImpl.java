package com.zbank.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zbank.dao.intfService.IntfServiceMapper;
import com.zbank.model.IntfService;
import com.zbank.service.IntfServiceService;

@Transactional
@org.springframework.stereotype.Service
public class IntfServiceServiceImpl implements IntfServiceService {

	@Autowired
	private IntfServiceMapper serviceMapper;

	private static Log log = LogFactory.getLog(IntfServiceServiceImpl.class);

	@Override
	public int insertService(IntfService service) throws Exception {
		//设置接口服务的唯一id
		String serviceId=UUID.randomUUID().toString();
		//设置接口创建的时间
		String serviceUpdatetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		service.setServiceId(serviceId);
		service.setServiceUpdatetime(serviceUpdatetime);
		return serviceMapper.insertService(service);
	}

	@Override
	public int uadateByPrimaryKey(IntfService service) throws Exception {
		//设置接口更新的时间
		String serviceUpdatetime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		service.setServiceUpdatetime(serviceUpdatetime);
		return serviceMapper.updateByPrimaryKeySelective(service);
	}

	@Override
	public int deleteByPrimaryKey(String serviceId) throws Exception {

		return serviceMapper.deleteByPrimaryKey(serviceId);
	}

	@Override
	public String serviceList(int limit, int offset, String serviceEnname, String serviceCnname, String serviceSystem,
			String serviceStatus) throws Exception {
		List<IntfService> list = serviceMapper.serviceList(limit, offset, serviceEnname, serviceCnname, serviceSystem,serviceStatus);
		//查询分页数据
		JSONArray serviceArray=JSONArray.parseArray(list.toString());
		JSONObject jsonObject = new JSONObject();
		// 查询数据总量 code和msg均无用，为了组装成layui_table的固定格式
		jsonObject.put("count",serviceMapper.seriveCount(limit, offset, serviceEnname, serviceCnname, serviceSystem, serviceStatus));
		jsonObject.put("data", serviceArray);
		jsonObject.put("code", 0);
		jsonObject.put("msg", "");
		if(log.isDebugEnabled()){
			log.debug("intfServiceInfo===" + jsonObject.toJSONString());
		}	
		return jsonObject.toJSONString();
	}

}
