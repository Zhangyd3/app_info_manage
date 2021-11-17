package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.BackendUser;

public interface BackendUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);
}