package com.zyd.appinfo.service.impl;

import com.zyd.appinfo.mapper.AppCategoryMapper;
import com.zyd.appinfo.pojo.AppCategory;
import com.zyd.appinfo.service.AppCategoryService;
import com.zyd.appinfo.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zyd
 * @Description TODO
 * @Date 2021/11/19 14:14
 */
@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {
    @Autowired
    private AppCategoryMapper appCategoryMapper;
    @Override
    public List<AppCategory> findByParentId(Integer id) {
        return appCategoryMapper.findByParentId(id);
    }

    @Override
    public List<AppCategory> findByLevel(Integer level) {
        return appCategoryMapper.findByLevel(level);
    }

}
