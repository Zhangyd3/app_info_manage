package com.zyd.appinfo.controller;

import com.zyd.appinfo.pojo.DevUser;
import com.zyd.appinfo.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

/**
 * @Author zyd
 * @Description TODO
 * @Date 2021/11/17 14:59
 */
@Controller
@RequestMapping("/dev")
public class DevUserController {
    @Autowired
    private DevUserService devUserService;
    @RequestMapping("/login")
    private String login(){
        return "devlogin";
    }
    @RequestMapping("/dologin")
    private String dologin(String devCode, String devPassword, HttpSession session){
        DevUser devUser = devUserService.findByDevCode(devCode);
        if (devUser!=null){
            if (devUser.getDevpassword().equals(devPassword)) {
                session.setAttribute("devUser",devUser);
                return "developer/main";
            }
            return "devlogin";
        }
        return "devlogin";
    }
    @RequestMapping("/logout")
    private String logout(HttpSession session){
        session.removeAttribute("devUser");
        return "redirect:/index.jsp";
    }
}
