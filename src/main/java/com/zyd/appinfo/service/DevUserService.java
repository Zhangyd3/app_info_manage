package com.zyd.appinfo.service;

import com.zyd.appinfo.pojo.DevUser;
import com.zyd.appinfo.tools.PageSupport;

public interface DevUserService {
    DevUser findByDevCode(String devCode);

}
