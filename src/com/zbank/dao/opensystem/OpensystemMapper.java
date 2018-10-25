package com.zbank.dao.opensystem;

import com.zbank.model.Opensystem;

public interface OpensystemMapper {
    int deleteByPrimaryKey(String openModuleId);

    int insert(Opensystem record);

    int insertSelective(Opensystem record);

    Opensystem selectByPrimaryKey(String openModuleId);

    int updateByPrimaryKeySelective(Opensystem record);

    int updateByPrimaryKey(Opensystem record);
}