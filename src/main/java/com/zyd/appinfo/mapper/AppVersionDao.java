package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.AppVersion;

public interface AppVersionDao {
    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);
}