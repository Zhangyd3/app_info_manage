package com.zyd.appinfo.service;

import com.zyd.appinfo.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {
    List<AppCategory> findByParentId(Integer id);
    List<AppCategory> findByLevel(Integer level);
}
