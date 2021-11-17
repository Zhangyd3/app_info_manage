package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.AppInfo;

public interface AppInfoDao {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
}