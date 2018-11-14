package com.zbank.controller;

import org.apache.commons.lang3.StringUtils;
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

import com.alibaba.fastjson.JSONObject;
import com.zbank.model.IntfService;
import com.zbank.service.IntfServiceService;

@Controller
@RequestMapping(value = "/intfService")
public class IntfServiceController {

	@Autowired
	private IntfServiceService service;
	private static Log log = LogFactory.getLog(IntfServiceController.class);

	/**
	 * 分页查询服务接口信息
	 * @param limit 每页数据限制量
	 * @param page  页码
	 * @param serviceEnname 服务接口英文名称
	 * @param serviceCnname 服务接口中文名称
	 * @param serviceSystem 服务所属系统
	 * @param serviceStatus 服务状态
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/serviceInfo", method = { RequestMethod.POST, RequestMethod.GET }, produces ="application/json;charset=UTF-8")
	@ResponseBody
	public String serviceInfo(@RequestParam("limit") int limit, @RequestParam("page") int page,
			@RequestParam(defaultValue = "", value = "serviceEnname") String serviceEnname,
			@RequestParam(defaultValue = "", value = "serviceCnname") String serviceCnname,
			@RequestParam(defaultValue = "", value = "serviceSystem") String serviceSystem,
			@RequestParam(defaultValue = "", value = "serviceStatus") String serviceStatus) throws Exception {
		int offset = limit * (page - 1);// 获取当前页第一位下标
		String serviceInfo = service.serviceList(limit, offset, serviceEnname, serviceCnname, serviceSystem, serviceStatus);
		return serviceInfo;
	}
	
	/**
	 * 新增服务接口
	 * @param service
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/addService",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public String addSystem(@RequestBody IntfService intfService) throws Exception{
		JSONObject jsonMsg=new JSONObject();
		
		if(StringUtils.isBlank(intfService.getServiceEnname())){
			jsonMsg.put("msg", "接口服务英文名不能为空！");
			return jsonMsg.toJSONString();
		}
		if(StringUtils.isBlank(intfService.getServiceCnname())){
			jsonMsg.put("msg", "接口服务中文名不能为空！");
			return jsonMsg.toJSONString();
		}
		if(StringUtils.isBlank(intfService.getServiceSystem())){
			jsonMsg.put("msg", "接口服务所属系统不能为空！");
			return jsonMsg.toJSONString();
		}
		int insertFlag=service.insertService(intfService);
		
		if(insertFlag==1){
			jsonMsg.put("msg", "数据添加成功！");
		}else{
			jsonMsg.put("msg", "数据添加失败！");
		}
		return jsonMsg.toJSONString();
	}
	
	/**
	 * 修改服务接口
	 * @param service
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/updateService",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateService(@RequestBody IntfService intfService) throws Exception{
		JSONObject jsonMsg=new JSONObject();
		
		if(StringUtils.isBlank(intfService.getServiceEnname())){
			jsonMsg.put("msg", "接口服务英文名不能为空！");
			return jsonMsg.toJSONString();
		}
		if(StringUtils.isBlank(intfService.getServiceCnname())){
			jsonMsg.put("msg", "接口服务中文名不能为空！");
			return jsonMsg.toJSONString();
		}
		if(StringUtils.isBlank(intfService.getServiceSystem())){
			jsonMsg.put("msg", "接口服务所属系统不能为空！");
			return jsonMsg.toJSONString();
		}
		int uadateFlag=service.uadateByPrimaryKey(intfService);
		
		if(uadateFlag==1){
			jsonMsg.put("msg", "数据修改成功！");
		}else{
			jsonMsg.put("msg", "数据修改失败！");
		}
		return jsonMsg.toJSONString();
	}
	
	/**
	 * 删除服务接口
	 * @param service
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/delService",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String delService(@RequestParam("serviceId") String serviceId) throws Exception{
		JSONObject jsonMsg=new JSONObject();
		
		int delFlag=service.deleteByPrimaryKey(serviceId);
		
		if(delFlag==1){
			jsonMsg.put("msg", "数据删除成功！");
		}else{
			jsonMsg.put("msg", "数据删除失败！");
		}
		return jsonMsg.toJSONString();
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
