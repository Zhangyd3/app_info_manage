package com.zyd.appinfo.controller;

import com.zyd.appinfo.pojo.AppVersion;
import com.zyd.appinfo.pojo.DevUser;
import com.zyd.appinfo.service.AppVersionService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author zyd
 * @Description TODO
 * @Date 2021/11/22 15:35
 */
@Controller
@RequestMapping("/dev/flatform/app")
public class AppVersionController {
    @Autowired
    private AppVersionService appVersionService;
    @RequestMapping("/appversionmodifysave")
    private String appversionmodifysave(AppVersion version, @RequestParam("attach") MultipartFile multipartFile, HttpSession session) {
        if (!multipartFile.isEmpty()) {
            String absolutePathPaths = "";
            String path = "AppInfoSystem" + File.separator + "statics" + File.separator + "uploadfiles";
            String fileName = multipartFile.getOriginalFilename();
            String extension = FilenameUtils.getExtension(fileName);

            if (multipartFile.getSize() > 500000000) {
                return "redirect:/dev/flatform/app/appinfomodify?id="+version.getId();
            }
            if (!(extension.equalsIgnoreCase("apk"))) {
                return "redirect:/dev/flatform/app/appinfomodify?id="+version.getId();
            }
            String newFileName=fileName.substring(0,fileName.lastIndexOf(".apk"))+System.currentTimeMillis()+""+((int)(Math.random()*1000))+".apk";
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
            version.setApkLocPath(absolutePathPaths);
            version.setApkFileName(newFileName);
            version.setDownloadLink(File.separator+path+File.separator+newFileName);
        }
        DevUser user = (DevUser) session.getAttribute("devUserSession");
        Date date=new Date();
        version.setModifyDate(date);
        version.setModifyBy(user.getId());
        Integer num = appVersionService.updateByPrimaryKeySelective(version);
        if (num==1){
            return "redirect:/dev/flatform/app/applist";
        }else {
            return "redirect:/dev/flatform/app/appinfomodify?id="+version.getId();
        }

    }
    @RequestMapping("/appversionadd")
    private String appversionAdd(Integer id, Model model){
        List<AppVersion> appVersionList = appVersionService.findByAppInfoId(id);
        AppVersion appVersion=new AppVersion();
        appVersion.setAppId(Long.valueOf(id));
        model.addAttribute("appVersion", appVersion);
        model.addAttribute("appVersionList",appVersionList);
        return "developer/appversionadd";
    }

    @RequestMapping("/addversionsave")
    private String addversionsave(AppVersion version, @RequestParam("a_downloadLink") MultipartFile multipartFile, HttpSession session) {
        if (!multipartFile.isEmpty()) {
            String absolutePathPaths = "";
            String path = "AppInfoSystem" + File.separator + "statics" + File.separator + "uploadfiles";
            String fileName = multipartFile.getOriginalFilename();
            String extension = FilenameUtils.getExtension(fileName);

            if (multipartFile.getSize() > 500000000) {
                return "redirect:/dev/flatform/app/appversionadd?id="+version.getAppId();
            }
            if (!(extension.equalsIgnoreCase("apk"))) {
                return "redirect:/dev/flatform/app/appversionadd?id="+version.getAppId();
            }
            String newFileName=fileName.substring(0,fileName.lastIndexOf(".apk"))+System.currentTimeMillis()+""+((int)(Math.random()*1000))+".apk";
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
            version.setApkLocPath(absolutePathPaths);
            version.setApkFileName(newFileName);
            version.setDownloadLink(File.separator+path+File.separator+newFileName);
        }
        DevUser user = (DevUser) session.getAttribute("devUserSession");
        Date date=new Date();
        version.setCreatedBy(user.getId());
        version.setCreationDate(date);
        version.setModifyDate(date);
        Integer num = appVersionService.insertSelective(version);
        if (num==1){
            return "redirect:/dev/flatform/app/applist";
        }else {
            return "redirect:/dev/flatform/app/appversionadd?id="+version.getAppId();
        }

    }
}
