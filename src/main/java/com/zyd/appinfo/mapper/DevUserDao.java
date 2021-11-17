package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.DevUser;

public interface DevUserDao {
    DevUser findByDevCode(String devCode);
}