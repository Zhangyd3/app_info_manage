package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionMapper {
    Integer deleteByPrimaryKey(Long id);

    Integer insert(AppVersion record);

    Integer insertSelective(AppVersion appVersion);

    AppVersion selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(AppVersion appVersion);

    Integer updateByPrimaryKey(AppVersion record);
    List<AppVersion> findByAppInfoId(Integer id);
    AppVersion findByAppIdAndVid(@Param("aid") Integer aid, @Param("vid") Integer vid);
    Integer delApkPath(Integer id);

}