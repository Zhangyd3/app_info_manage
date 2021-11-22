package com.zyd.appinfo.controller;

import com.zyd.appinfo.mapper.AppCategoryMapper;
import com.zyd.appinfo.pojo.*;
import com.zyd.appinfo.service.AppCategoryService;
import com.zyd.appinfo.service.AppInfoService;
import com.zyd.appinfo.service.AppVersionService;
import com.zyd.appinfo.service.DataDictionaryService;
import com.zyd.appinfo.tools.PageSupport;
import jdk.nashorn.internal.runtime.Version;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
    private AppVersionService appVersionService;
    @Autowired
    private AppCategoryService appCategoryService;
    @Autowired
    private DataDictionaryService dataDictionaryService;

    @RequestMapping("/applist")
    private String appList(Model model, AppInfo appInfo, @RequestParam(defaultValue = "1") Integer pageIndex) {
        List<AppInfo> appInfoList = appInfoService.findAppByAppInfo(appInfo, pageIndex);
        PageSupport pages = appInfoService.getPageInfo(appInfo, pageIndex);
        List<AppCategory> categoryLevel1List = appCategoryService.findByLevel(1);
        List<AppCategory> categoryLevel2List = appCategoryService.findByLevel(2);
        List<AppCategory> categoryLevel3List = appCategoryService.findByLevel(3);
        List<DataDictionary> statusList = dataDictionaryService.findByTypeCode("APP_STATUS");
        List<DataDictionary> flatFormList = dataDictionaryService.findByTypeCode("APP_FLATFORM");
        model.addAttribute("pages", pages);
        model.addAttribute("appInfoList", appInfoList);
        model.addAttribute("statusList", statusList);
        model.addAttribute("flatFormList", flatFormList);
        model.addAttribute("categoryLevel1List", categoryLevel1List);
        model.addAttribute("categoryLevel2List", categoryLevel2List);
        model.addAttribute("categoryLevel3List", categoryLevel3List);
        return "developer/appinfolist";
    }

    @RequestMapping("/appinfomodify")
    private String appinfoModify(Integer id, Model model) {
        AppInfo appInfo = appInfoService.findAppByid(id);
        model.addAttribute("appInfo", appInfo);
        return "developer/appinfomodify";
    }

    @RequestMapping("/categorylevellist.json")
    @ResponseBody
    private List<AppCategory> datadictionaryList(Integer pid) {
        List<AppCategory> byParentId = appCategoryService.findByParentId(pid);
        return byParentId;
    }

    @RequestMapping("/datadictionarylist.json")
    @ResponseBody
    private List<DataDictionary> datadictionarylist(String tcode) {
        List<DataDictionary> typeCode = dataDictionaryService.findByTypeCode(tcode);
        return typeCode;
    }

    @RequestMapping("/delfile.json")
    @ResponseBody
    private String delfile(Integer id, String filepath,String flag) {
        Integer num=0;
        if (flag.equals("logo")) {
            num = appInfoService.delAppLogoFile(id, filepath);
        }
        if (flag.equals("apk")){
            num= appVersionService.delApkPath(id, filepath);
        }
        if (num == 1) {
            return "{\"result\":\"success\"}";
        }
        return "{\"result\":\"failed\"}";
    }

    @RequestMapping("/appinfomodifysave")
    private String appinfomodifysave(AppInfo appInfo, @RequestParam("attach") MultipartFile multipartFile, HttpSession session) {
        if (!multipartFile.isEmpty()) {
            String absolutePathPaths = "";
            String path = "AppInfoSystem" + File.separator + "statics" + File.separator + "uploadfiles";
            String fileName = multipartFile.getOriginalFilename();
            String extension = FilenameUtils.getExtension(fileName);
            if (multipartFile.getSize() > 5000000) {
                return "redirect:/dev/flatform/app/appinfomodify?id="+appInfo.getId();
            }
            if (!(extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("pneg"))) {
                return "redirect:/dev/flatform/app/appinfomodify?id="+appInfo.getId();
            }
            String absolutePath = session.getServletContext().getRealPath(path);
            File file = new File(absolutePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file1 = new File(absolutePath, fileName);
            try {
                multipartFile.transferTo(file1);
                absolutePathPaths += absolutePath + File.separator + fileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
            appInfo.setLogoLocPath(absolutePathPaths);
            appInfo.setLogoPicPath(File.separator+path+File.separator+fileName);
        }
        DevUser user = (DevUser) session.getAttribute("devUserSession");
        Date date=new Date();
        appInfo.setModifyDate(date);
        appInfo.setUpdateDate(date);
        appInfo.setModifyBy(user.getId());
        Integer num = appInfoService.updateAppInfo(appInfo);
        if (num==1){
            return "redirect:/dev/flatform/app/applist";
        }else {
            return "redirect:/dev/flatform/app/appinfomodify?id="+appInfo.getId();
        }

    }
    @RequestMapping("/appinfoaddsave")
    private String appinfoaddsave(AppInfo appInfo, @RequestParam("a_logoPicPath") MultipartFile multipartFile, HttpSession session) {
        if (!multipartFile.isEmpty()) {
            String absolutePathPaths = "";
            String path = "AppInfoSystem" + File.separator + "statics" + File.separator + "uploadfiles";
            String fileName = multipartFile.getOriginalFilename();
            String extension = FilenameUtils.getExtension(fileName);
            if (multipartFile.getSize() > 5000000) {
                return "redirect:/dev/flatform/app/appinfoadd";
            }
            if (!(extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg") || extension.equalsIgnoreCase("pneg"))) {
                return "redirect:/dev/flatform/app/appinfoadd";
            }
            String newFileName=fileName.substring(0,fileName.lastIndexOf("."+extension))+System.currentTimeMillis()+""+((int)(Math.random()*1000))+"."+extension;
            String absolutePath = session.getServletContext().getRealPath(path);
            File file = new File(absolutePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file1 = new File(absolutePath, newFileName);
            try {
                multipartFile.transferTo(file1);
                absolutePathPaths += absolutePath + File.separator + newFileName;
            } catch (IOException e) {
                e.printStackTrace();
            }
            appInfo.setLogoLocPath(absolutePathPaths);
            appInfo.setLogoPicPath(File.separator+path+File.separator+newFileName);
        }
        DevUser user = (DevUser) session.getAttribute("devUserSession");
        Date date=new Date();
        appInfo.setModifyDate(date);
        appInfo.setUpdateDate(date);
        appInfo.setModifyBy(user.getId());
        Integer num = appInfoService.insertAppByAppInfo(appInfo);
        if (num==1){
            return "redirect:/dev/flatform/app/applist";
        }else {
            return "redirect:/dev/flatform/app/appinfoadd";
        }

    }
    @RequestMapping("appinfoadd")
    private String appinfoadd(){
        return "developer/appinfoadd";
    }
    @RequestMapping("apkexist.json")
    @ResponseBody
    private String apkexist(String APKName){
        if (APKName==null){
            return "{\"APKName\":\"empty\"}";
        }
        Integer num = appInfoService.apkNameExist(APKName);
        if (num>=1){
            return "{\"APKName\":\"exist\"}";
        }
        return "{\"APKName\":\"noexist\"}";
    }

    @RequestMapping("/appview/{id}")
    private String appView(@PathVariable("id") Integer id, Model model) {
        AppInfo appInfo = appInfoService.findAppByid(id);
        model.addAttribute("appInfo", appInfo);
        List<AppVersion> appVersionList = appVersionService.findByAppInfoId(id);
        model.addAttribute("appVersionList", appVersionList);
        return "developer/appinfoview";
    }
    @RequestMapping("/appversionmodify")
    private String appView(Integer vid, Integer aid,Model model) {
        AppVersion  appVersion= appVersionService.findByAppIdAndVid(aid, vid);
        List<AppVersion> appVersionList = appVersionService.findByAppInfoId(aid);
        model.addAttribute("appVersionList", appVersionList);
        model.addAttribute("appVersion", appVersion);
        return "developer/appversionmodify";
    }
    @RequestMapping("/delapp.json")
    @ResponseBody
    private String delaApp(Integer id, Model model) {
        Integer num = appInfoService.delAppInfo(id);
        if (num==1) {
            return "{\"delResult\":\"true\"}";
        }
        return "{\"delResult\":\"false\"}";
    }

    @ExceptionHandler (value = {Exception.class})
    private void handlerException(Exception e){
        e.printStackTrace();
    }

}
