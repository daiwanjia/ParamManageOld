package com.zbank.dao.environment;

import com.zbank.model.environment;

public interface environmentMapper {
    int deleteByPrimaryKey(String environmentId);

    int insert(environment record);

    int insertSelective(environment record);

    environment selectByPrimaryKey(String environmentId);

    int updateByPrimaryKeySelective(environment record);

    int updateByPrimaryKey(environment record);
}