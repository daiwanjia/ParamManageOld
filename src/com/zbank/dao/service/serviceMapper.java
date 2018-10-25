package com.zbank.dao.service;

import com.zbank.model.service;

public interface serviceMapper {
    int deleteByPrimaryKey(String serviceId);

    int insert(service record);

    int insertSelective(service record);

    service selectByPrimaryKey(String serviceId);

    int updateByPrimaryKeySelective(service record);

    int updateByPrimaryKey(service record);
}