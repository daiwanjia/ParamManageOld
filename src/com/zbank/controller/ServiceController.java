package com.zbank.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbank.service.ServiceService;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

	@Autowired
	private ServiceService service;
	private static Log log = LogFactory.getLog(ServiceController.class);

	@RequestMapping(value = "/serviceInfo", method = { RequestMethod.POST, RequestMethod.GET }, produces = {
			"application/json;charset=UTF-8" })
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
}
