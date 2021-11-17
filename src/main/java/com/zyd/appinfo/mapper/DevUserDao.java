package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.DevUser;

public interface DevUserDao {
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);
    DevUser findByDevCode(String devCode);
    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}