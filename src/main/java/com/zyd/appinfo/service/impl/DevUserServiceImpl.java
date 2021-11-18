package com.zyd.appinfo.service.impl;

import com.zyd.appinfo.mapper.DevUserMapper;
import com.zyd.appinfo.pojo.DevUser;
import com.zyd.appinfo.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zyd
 * @Description TODO
 * @Date 2021/11/17 16:23
 */
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    private DevUserMapper devUserMapper;
    @Override
    public DevUser findByDevCode(String devCode) {
        return devUserMapper.findByDevCode(devCode);
    }
}
