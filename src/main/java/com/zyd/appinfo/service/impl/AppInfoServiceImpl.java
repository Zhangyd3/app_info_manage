package com.zyd.appinfo.service.impl;

import com.zyd.appinfo.mapper.AppInfoMapper;
import com.zyd.appinfo.pojo.AppInfo;
import com.zyd.appinfo.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zyd
 * @Description TODO
 * @Date 2021/11/18 22:45
 */
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Override
    public List<AppInfo> findAppByAppInfo(AppInfo appInfo, Integer start) {
        return appInfoMapper.findAppByAppInfo(appInfo, start);
    }
}
