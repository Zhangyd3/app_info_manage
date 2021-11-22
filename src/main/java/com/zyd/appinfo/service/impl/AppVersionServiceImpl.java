package com.zyd.appinfo.service.impl;

import com.zyd.appinfo.mapper.AppInfoMapper;
import com.zyd.appinfo.mapper.AppVersionMapper;
import com.zyd.appinfo.pojo.AppVersion;
import com.zyd.appinfo.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * @Author zyd
 * @Description TODO
 * @Date 2021/11/22 14:18
 */
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;
    @Autowired
    private AppInfoMapper appInfoMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<AppVersion> findByAppInfoId(Integer id) {
        return appVersionMapper.findByAppInfoId(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public AppVersion findByAppIdAndVid(Integer aid, Integer vid) {
        return appVersionMapper.findByAppIdAndVid(aid, vid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer delApkPath(Integer id, String path) {
        File file=new File(path);
        if (file.exists()) {
            file.delete();
        }
        return appVersionMapper.delApkPath(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insertSelective(AppVersion appVersion) {
        appVersionMapper.insertSelective(appVersion);
        return appInfoMapper.updateAppVersion(appVersion.getId(), appVersion.getAppId());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByPrimaryKeySelective(AppVersion appVersion) {
        return appVersionMapper.updateByPrimaryKeySelective(appVersion);
    }
}
