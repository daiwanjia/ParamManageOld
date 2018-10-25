package com.zbank.dao.environment;

import com.zbank.model.Environment;

public interface EnvironmentMapper {
    int deleteByPrimaryKey(String environmentId);

    int insert(Environment record);

    int insertSelective(Environment record);

    Environment selectByPrimaryKey(String environmentId);

    int updateByPrimaryKeySelective(Environment record);

    int updateByPrimaryKey(Environment record);
}