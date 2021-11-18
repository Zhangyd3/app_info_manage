package com.zyd.appinfo.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * app_info
 * @author 
 */
public class AppInfo implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 软件名称
     */
    private String softwareName;

    /**
     * APK名称（唯一）
     */
    private String APKName;

    /**
     * 支持ROM
     */
    private String supportROM;

    /**
     * 界面语言
     */
    private String interfaceLanguage;

    /**
     * 软件大小（单位：M）
     */
    private BigDecimal softwareSize;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 开发者id（来源于：dev_user表的开发者id）
     */
    private Long devId;

    /**
     * 应用简介
     */
    private String appInfo;

    /**
     * 状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
     */
    private Long status;

    /**
     * 上架时间
     */
    private Date onSaleDate;

    /**
     * 下架时间
     */
    private Date offSaleDate;

    /**
     * 所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
     */
    private Long flatformId;
    private String statusName;
    private String flatformName;

    public String getFlatformName() {
        return flatformName;
    }

    public void setFlatformName(String flatformName) {
        this.flatformName = flatformName;
    }

    /**
     * 所属三级分类（来源于：data_dictionary）
     */
    private Long categoryLevel3;
    private String categoryLevel3Name;
    private String categoryLevel2Name;
    private String categoryLevel1Name;
    /**
     * 下载量（单位：次）
     */
    private Long downloads;

    /**
     * 创建者（来源于dev_user开发者信息表的用户id）
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private Date creationDate;

    /**
     * 更新者（来源于dev_user开发者信息表的用户id）
     */
    private Long modifyBy;

    /**
     * 最新更新时间
     */
    private Date modifyDate;

    /**
     * 所属一级分类（来源于：data_dictionary）
     */
    private Long categoryLevel1;

    /**
     * 所属二级分类（来源于：data_dictionary）
     */
    private Long categoryLevel2;

    /**
     * LOGO图片url路径
     */
    private String logoPicPath;

    /**
     * LOGO图片的服务器存储路径
     */
    private String logoLocPath;

    /**
     * 最新的版本id
     */
    private Long versionId;
    private String versionNo;

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getAPKName() {
        return APKName;
    }

    public void setAPKName(String APKName) {
        this.APKName = APKName;
    }

    public String getSupportROM() {
        return supportROM;
    }

    public void setSupportROM(String supportROM) {
        this.supportROM = supportROM;
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

    public BigDecimal getSoftwareSize() {
        return softwareSize;
    }

    public void setSoftwareSize(BigDecimal softwareSize) {
        this.softwareSize = softwareSize;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public Date getOffSaleDate() {
        return offSaleDate;
    }

    public void setOffSaleDate(Date offSaleDate) {
        this.offSaleDate = offSaleDate;
    }

    public Long getFlatformId() {
        return flatformId;
    }

    public void setFlatformId(Long flatformId) {
        this.flatformId = flatformId;
    }

    public Long getCategoryLevel3() {
        return categoryLevel3;
    }

    public void setCategoryLevel3(Long categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(Long categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    public Long getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(Long categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public String getLogoPicPath() {
        return logoPicPath;
    }

    public void setLogoPicPath(String logoPicPath) {
        this.logoPicPath = logoPicPath;
    }

    public String getLogoLocPath() {
        return logoLocPath;
    }

    public void setLogoLocPath(String logoLocPath) {
        this.logoLocPath = logoLocPath;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCategoryLevel3Name() {
        return categoryLevel3Name;
    }

    public void setCategoryLevel3Name(String categoryLevel3Name) {
        this.categoryLevel3Name = categoryLevel3Name;
    }

    public String getCategoryLevel2Name() {
        return categoryLevel2Name;
    }

    public void setCategoryLevel2Name(String categoryLevel2Name) {
        this.categoryLevel2Name = categoryLevel2Name;
    }

    public String getCategoryLevel1Name() {
        return categoryLevel1Name;
    }

    public void setCategoryLevel1Name(String categoryLevel1Name) {
        this.categoryLevel1Name = categoryLevel1Name;
    }
}