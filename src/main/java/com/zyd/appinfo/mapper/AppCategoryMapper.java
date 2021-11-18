package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.AppCategory;

import java.util.List;

public interface AppCategoryMapper {
    List<AppCategory> findByParentId(Integer id);
}