package com.zyd.appinfo.service;

import com.zyd.appinfo.pojo.DevUser;

public interface DevUserService {
    DevUser findByDevCode(String devCode);
}
