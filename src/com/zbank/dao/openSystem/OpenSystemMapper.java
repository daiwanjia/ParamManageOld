package com.zbank.dao.openSystem;

import com.zbank.model.OpenSystem;

public interface OpenSystemMapper {
    int deleteByPrimaryKey(String openModuleId);

    int insert(OpenSystem record);

    int insertSelective(OpenSystem record);

    OpenSystem selectByPrimaryKey(String openModuleId);

    int updateByPrimaryKeySelective(OpenSystem record);

    int updateByPrimaryKey(OpenSystem record);
}