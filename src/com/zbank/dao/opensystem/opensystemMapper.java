package com.zbank.dao.opensystem;

import com.zbank.model.opensystem;

public interface opensystemMapper {
    int deleteByPrimaryKey(String openModuleId);

    int insert(opensystem record);

    int insertSelective(opensystem record);

    opensystem selectByPrimaryKey(String openModuleId);

    int updateByPrimaryKeySelective(opensystem record);

    int updateByPrimaryKey(opensystem record);
}