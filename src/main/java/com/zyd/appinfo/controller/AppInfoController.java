package com.zyd.appinfo.controller;

import com.zyd.appinfo.pojo.AppInfo;
import com.zyd.appinfo.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author zyd
 * @Description TODO
 * @Date 2021/11/18 22:39
 */
@Controller
@RequestMapping("/dev/flatform/app")
public class AppInfoController {
    @Autowired
    private AppInfoService appInfoService;
    @RequestMapping("/applist")
    private String appList(Model model, AppInfo appInfo, @RequestParam(defaultValue = "1") Integer pageNum){
        List<AppInfo> appInfoList = appInfoService.findAppByAppInfo(appInfo, pageNum);
        model.addAttribute("appInfoList",appInfoList);
        return "developer/appinfolist";
    }
}
