package com.zbank.dao.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zbank.model.Service;

@Mapper
public interface ServiceMapper {
	
	int insert(Service service);

	Service selectByPrimaryKey(String serviceId);

	int updateByPrimaryKeySelective(Service record);
	
	/**
	 * 删除服务
	 * @param serviceId 服务id
	 * @return int
	 */
	int deleteByPrimaryKey(String serviceId);
	
	/**
	 * 修改服务信息
	 * @param record
	 * @return int
	 */
	int updateByPrimaryKey(Service record);
	
	/**
	 * 新增接口
	 * 
	 * @param service
	 * @return
	 */
	int insertService(Service service);

	/**
	 * 查询接口信息
	 * @param limit  每页的数量
	 * @param offset 起始下标
	 * @param serviceEnname 服务英文名称
	 * @param serviceCnname 服务中文名称
	 * @param serviceSystem 服务所属系统
	 * @param serviceStatus 服务状态
	 * @return
	 */
	List<Service> serviceList(@Param("limit") int limit, @Param("offset") int offset,
			@Param("serviceEnname") String serviceEnname, @Param("serviceCnname") String serviceCnname,
			@Param("serviceSystem") String serviceSystem, @Param("serviceStatus") String serviceStatus);

	/**
	 * 查询接口信息总量
	 * @param limit  每页的数量
	 * @param offset 起始下标
	 * @param serviceEnname 服务英文名称
	 * @param serviceCnname 服务中文名称
	 * @param serviceSystem 服务所属系统
	 * @param serviceStatus 服务状态
	 * @return int
	 */
	int seriveCount(@Param("limit") int limit, @Param("offset") int offset,
			@Param("serviceEnname") String serviceEnname, @Param("serviceCnname") String serviceCnname,
			@Param("serviceSystem") String serviceSystem, @Param("serviceStatus") String serviceStatus);

}