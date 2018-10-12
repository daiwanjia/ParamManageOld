package com.zbank.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zbank.model.System;
import com.zbank.service.SystemService;

@Controller(value="systemController")
@RequestMapping(value="/system")
public class SystemController {
	@Autowired
	private SystemService systemService;
	
	private static Log log=LogFactory.getLog(SystemController.class);
	
	/**
	 * 分页查询系统信息
	 * @param limit 每页总数据量
	 * @param page  当前页码
	 * @return  
	 */
	@ResponseBody
	@RequestMapping(value="/systemInfo",method={RequestMethod.POST,RequestMethod.GET},produces={"application/json;charset=UTF-8"})
	public String systemInfo(@RequestParam("limit") int limit,@RequestParam("page") int page){
		int offset=limit*(page-1);//获取当前页第一位下标
		List<System> systemList=systemService.systemList(limit,offset);
		
		//查询分页数据
		JSONArray dataArray=new JSONArray();
		for (int i = 0; i < systemList.size(); i++) {
			dataArray.add(JSON.parseObject(systemList.get(i).toString()));
		}
		JSONObject jsonObject=new JSONObject();
		//查询数据总量
		jsonObject.put("count", systemService.systemCout());
		jsonObject.put("data", dataArray);
		jsonObject.put("code",0);
		jsonObject.put("msg", "");
		log.info("systemInfo==="+jsonObject.toJSONString());
		return jsonObject.toJSONString();
	}
	/**
	 * 新增系统
	 * @param system
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addSystem",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public String addSystem(@RequestBody System system){
		int insertFlag=systemService.addSystem(system);
		JSONObject jsonObject=new JSONObject();
		if(insertFlag==1){
			jsonObject.put("msg", "数据添加成功！");
		}else{
			jsonObject.put("msg", "数据添加失败！");
		}
		return jsonObject.toJSONString();
	}
	/**
	 * 修改系统信息
	 * @param system
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateSystem",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String uadateSystem(@RequestBody System system){
		int uadateFlag=systemService.updateSystem(system);
		JSONObject jsonObject=new JSONObject();
		if(uadateFlag==1){
			jsonObject.put("msg", "数据修改成功！");
		}else{
			jsonObject.put("msg", "数据修改失败！");
		}
		return jsonObject.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="/deleteSystem",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String deleteSystem(@RequestParam("systemEnname") String systemEnname){
		int uadateFlag=systemService.deleteSystem(systemEnname);
		JSONObject jsonObject=new JSONObject();
		if(uadateFlag==1){
			jsonObject.put("msg", "数据删除成功！");
		}else{
			jsonObject.put("msg", "数据删除失败！");
		}
		return jsonObject.toJSONString();
	}
	/**
	 * 异常处理
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public String ExceptionOut(Exception ex){
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("msg", "系统异常！ -----"+ex);	
		return jsonObject.toJSONString();
	}
}
