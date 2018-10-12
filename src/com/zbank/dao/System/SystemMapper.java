package com.zbank.dao.System;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zbank.model.System;
@Mapper
public interface SystemMapper {
	/**
	 * 删除系统
	 * @param systemEnname
	 * @return
	 */
    int deleteByPrimaryKey(String systemEnname);
    
    /**
     * 新增系统
     * @param system
     * @return
     */
    int insert(System system);

    int insertSelective(System record);

    System selectByPrimaryKey(String systemEnname);

    int updateByPrimaryKeySelective(System record);

    /**
     * 修改系统信息
     * @param system
     * @return
     */
    int updateByPrimaryKey(System system);
    
    /**
     * 查询所有系统信息
     * @param limit 每页的数量
     * @param offset 起始下标
     * @return systemInfoList
     */
    List<System> systemInfoList(@Param("limit")int limit,@Param("offset")int offset);
    
    /**
     * 查询system总量
     * @return int
     */
    int systemCount();
}