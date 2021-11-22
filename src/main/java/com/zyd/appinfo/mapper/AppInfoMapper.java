package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {
    List<AppInfo> findAppByAppInfo(@Param("appInfo") AppInfo appInfo, @Param("start") Integer start);
    AppInfo findAppByid(Integer id);
    Integer updateAppInfo(AppInfo appInfo);
    Integer getCountByAppInfo(@Param("appInfo") AppInfo appInfo);
    Integer delAppLogoFile(Integer id);
    Integer delAppInfo(Integer id);
    Integer apkNameExist(String apkName);
    Integer updateAppVersion(@Param("vid") Long vid, @Param("id") Long id);
    Integer insertAppByAppInfo(AppInfo appInfo);
}