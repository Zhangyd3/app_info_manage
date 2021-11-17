package com.zyd.appinfo.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * ad_promotion
 * @author 
 */
public class AppInfo implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * appId（来源于：app_info表的主键id）
     */
    private Long appid;

    /**
     * 广告图片存储路径
     */
    private String adpicpath;

    /**
     * 广告点击量
     */
    private Long adpv;

    /**
     * 轮播位（1-n）
     */
    private Integer carouselposition;

    /**
     * 起效时间
     */
    private Date starttime;

    /**
     * 失效时间
     */
    private Date endtime;

    /**
     * 创建者（来源于backend_user用户表的用户id）
     */
    private Long createdby;

    /**
     * 创建时间
     */
    private Date creationdate;

    /**
     * 更新者（来源于backend_user用户表的用户id）
     */
    private Long modifyby;

    /**
     * 最新更新时间
     */
    private Date modifydate;

    private static final long serialVersionUID = 1L;
}