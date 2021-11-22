package com.zyd.appinfo.service.impl;

import com.zyd.appinfo.mapper.AppInfoMapper;
import com.zyd.appinfo.pojo.AppInfo;
import com.zyd.appinfo.service.AppInfoService;
import com.zyd.appinfo.tools.Constants;
import com.zyd.appinfo.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
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
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public PageSupport getPageInfo(AppInfo appInfo,Integer pageNum) {
        Integer count = appInfoMapper.getCountByAppInfo(appInfo);
        PageSupport pageSupport=new PageSupport();
        pageSupport.setPageSize(Constants.pageSize);
        pageSupport.setTotalCount(count);
        Integer pageCount=count%Constants.pageSize==0?count/Constants.pageSize:count/Constants.pageSize+1;
        pageSupport.setTotalPageCount(pageCount);
        pageSupport.setCurrentPageNo(pageNum);
        return pageSupport;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<AppInfo> findAppByAppInfo(AppInfo appInfo, Integer pageNum) {
        Integer satrt=(pageNum-1)*Constants.pageSize;
        return appInfoMapper.findAppByAppInfo(appInfo, satrt);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public AppInfo findAppByid(Integer id) {
        return appInfoMapper.findAppByid(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer apkNameExist(String apkName) {
        return appInfoMapper.apkNameExist(apkName);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer updateAppInfo(AppInfo appInfo) {
        return appInfoMapper.updateAppInfo(appInfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer delAppLogoFile(Integer id, String logopath) {
        File file=new File(logopath);
        if (file.exists()){
            file.delete();
        }
        return appInfoMapper.delAppLogoFile(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insertAppByAppInfo(AppInfo appInfo) {
        return appInfoMapper.insertAppByAppInfo(appInfo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer delAppInfo(Integer id) {
        return appInfoMapper.delAppInfo(id);
    }

}
