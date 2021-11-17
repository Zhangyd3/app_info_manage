package com.zyd.appinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author zyd
 * @Description TODO
 * @Date 2021/11/17 14:59
 */
@Controller
@RequestMapping("/dev")
public class DevUserController {
    @RequestMapping("/login")
    private String login(){
        return "devlogin";
    }
    @RequestMapping("/dologin")
    private String dologin(String devCode,String devPassword){
        return "devloper/main";
    }
}
