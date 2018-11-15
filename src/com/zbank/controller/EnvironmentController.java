package com.zbank.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zbank.model.Environment;
import com.zbank.service.EnvironmentService;

@Controller
@RequestMapping(value = "/environment")
public class EnvironmentController {

	@Autowired
	private EnvironmentService environmentService;

	/**
	 * 查询环境清单
	 * 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/environmentInfo", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json;charset=UTF-8")
	public String queryEnvironmentInfo() throws Exception {

		return environmentService.queryEnvronmentInfo();
	}

	/**
	 * 新增环境信息
	 * 
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/addEnvironment", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public String addEnvironment(@RequestBody Environment environment) throws Exception {
		JSONObject jsonMsg = new JSONObject();

		if (StringUtils.isBlank(environment.getEnvironmentName())) {
			jsonMsg.put("msg", "环境名称不能为空！");
			return jsonMsg.toJSONString();
		}
		if (StringUtils.isBlank(environment.getEnvironmentUrl())) {
			jsonMsg.put("msg", "环境地址不能为空！");
			return jsonMsg.toJSONString();
		}
		int insertFlag = environmentService.insert(environment);

		if (insertFlag == 1) {
			jsonMsg.put("msg", "数据添加成功！");
		} else {
			jsonMsg.put("msg", "数据添加失败！");
		}
		return jsonMsg.toJSONString();
	}

	/**
	 * 修改环境信息
	 * 
	 * @param environment
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/updateEnvironment", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public String updateEnvironment(@RequestBody Environment environment) throws Exception {
		JSONObject jsonMsg = new JSONObject();

		if (StringUtils.isBlank(environment.getEnvironmentName())) {
			jsonMsg.put("msg", "环境名称不能为空！");
			return jsonMsg.toJSONString();
		}
		if (StringUtils.isBlank(environment.getEnvironmentUrl())) {
			jsonMsg.put("msg", "环境地址不能为空！");
			return jsonMsg.toJSONString();
		}
		int updateFlag = environmentService.updateByPrimaryKey(environment);
		if (updateFlag == 1) {
			jsonMsg.put("msg", "数据修改成功！");
		} else {
			jsonMsg.put("msg", "数据修改失败！");
		}
		return jsonMsg.toJSONString();
	}

	/**
	 * 删除服务接口
	 * 
	 * @param environmentId
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/delEnvironment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String delService(@RequestParam("environmentId") String environmentId) throws Exception {
		JSONObject jsonMsg = new JSONObject();

		int delFlag = environmentService.deleteByPrimaryKey(environmentId);

		if (delFlag == 1) {
			jsonMsg.put("msg", "数据删除成功！");
		} else {
			jsonMsg.put("msg", "数据删除失败！");
		}
		return jsonMsg.toJSONString();
	}

	/**
	 * 异常处理
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public String ExceptionOut(Exception ex) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "系统异常！ -----" + ex);
		return jsonObject.toJSONString();
	}

}
