package com.zyd.appinfo.mapper;

import com.zyd.appinfo.pojo.DevUser;

public interface DevUserMapper {
    DevUser findByDevCode(String devCode);

}
