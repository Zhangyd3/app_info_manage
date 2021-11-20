package com.zyd.appinfo.controller;

import com.zyd.appinfo.mapper.AppCategoryMapper;
import com.zyd.appinfo.pojo.AppCategory;
import com.zyd.appinfo.pojo.AppInfo;
import com.zyd.appinfo.pojo.DataDictionary;
import com.zyd.appinfo.service.AppCategoryService;
import com.zyd.appinfo.service.AppInfoService;
import com.zyd.appinfo.service.DataDictionaryService;
import com.zyd.appinfo.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    @Autowired
    private AppCategoryService appCategoryService;
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @RequestMapping("/applist")
    private String appList(Model model, AppInfo appInfo, @RequestParam(defaultValue = "1") Integer pageIndex){
        List<AppInfo> appInfoList = appInfoService.findAppByAppInfo(appInfo, pageIndex);
        PageSupport pages = appInfoService.getPageInfo(appInfo, pageIndex);
        List<AppCategory> categoryLevel1List = appCategoryService.findByLevel(1);
        List<AppCategory> categoryLevel2List = appCategoryService.findByLevel(2);
        List<AppCategory> categoryLevel3List = appCategoryService.findByLevel(3);
        List<DataDictionary> statusList = dataDictionaryService.findByTypeCode("APP_STATUS");
        List<DataDictionary> flatFormList = dataDictionaryService.findByTypeCode("APP_FLATFORM");
        model.addAttribute("pages", pages);
        model.addAttribute("appInfoList",appInfoList);
        model.addAttribute("statusList",statusList);
        model.addAttribute("flatFormList",flatFormList);
        model.addAttribute("categoryLevel1List", categoryLevel1List);
        model.addAttribute("categoryLevel2List", categoryLevel2List);
        model.addAttribute("categoryLevel3List", categoryLevel3List);
        return "developer/appinfolist";
    }
    @RequestMapping("/appinfomodify")
    private String appinfoModify(Integer id,Model model){
        AppInfo appInfo = appInfoService.findAppByid(id);
        model.addAttribute("appInfo", appInfo);
        return "developer/appinfomodify";
    }
    @RequestMapping("/categorylevellist.json")
    @ResponseBody
    private List<AppCategory> datadictionaryList(Integer pid){
        List<AppCategory> byParentId = appCategoryService.findByParentId(pid);
        return byParentId;
    }
    @RequestMapping("/datadictionarylist.json")
    @ResponseBody
        private List<DataDictionary> datadictionarylist(String tcode){
        List<DataDictionary> typeCode = dataDictionaryService.findByTypeCode(tcode);
        return typeCode;
    }
}
