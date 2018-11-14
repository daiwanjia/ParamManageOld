package com.zbank.service;

import com.zbank.model.IntfService;

public interface IntfServiceService {
	/**
	 * 新增接口
	 * 
	 * @param service
	 * @return int
	 * @throws Exception
	 */
	int insertService(IntfService service) throws Exception;

	/**
	 * 修改服务信息
	 * 
	 * @param recode
	 * @return int
	 * @throws Exception
	 */
	int uadateByPrimaryKey(IntfService service) throws Exception;

	/**
	 * 删除服务
	 * 
	 * @param serviceId
	 *            服务id
	 * @return int
	 * @throws Exception
	 */
	int deleteByPrimaryKey(String serviceId) throws Exception;
	/**
	 * 查询接口信息
	 * @param limit  每页的数量
	 * @param offset 起始下标
	 * @param serviceEnname 服务英文名称
	 * @param serviceCnname 服务中文名称
	 * @param serviceSystem 服务所属系统
	 * @param serviceStatus 服务状态
	 * @return serviceList
	 */
	String serviceList(int limit, int offset, String serviceEnname, String serviceCnname, String serviceSystem,
			String serviceStatus)throws Exception;
}
