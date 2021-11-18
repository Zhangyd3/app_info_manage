package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {
    List<AppInfo> findAppByAppInfo(@Param("appInfo") AppInfo appInfo, @Param("start") Integer start);
}