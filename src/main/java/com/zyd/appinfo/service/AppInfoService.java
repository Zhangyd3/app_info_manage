package com.zyd.appinfo.service;

import com.zyd.appinfo.pojo.AppInfo;
import com.zyd.appinfo.tools.PageSupport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoService {
    PageSupport getPageInfo(AppInfo appInfo,Integer pageNum);
    List<AppInfo> findAppByAppInfo(@Param("appInfo") AppInfo appInfo, @Param("start") Integer start);
    AppInfo findAppByid(Integer id);
    Integer updateAppInfo(AppInfo appInfo);
}
