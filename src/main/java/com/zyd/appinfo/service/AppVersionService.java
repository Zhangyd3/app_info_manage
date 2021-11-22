package com.zyd.appinfo.service;

import com.zyd.appinfo.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionService {
    List<AppVersion> findByAppInfoId(Integer id);
    AppVersion findByAppIdAndVid (Integer aid,Integer vid);
    Integer delApkPath(Integer id,String path);
    Integer insertSelective(AppVersion appVersion);
    int updateByPrimaryKeySelective(AppVersion appVersion);
}
