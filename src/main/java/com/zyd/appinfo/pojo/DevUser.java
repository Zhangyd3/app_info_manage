package com.zyd.appinfo.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * dev_user
 * @author 
 */
@Data
public class DevUser implements Serializable {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 开发者帐号
     */
    private String devcode;

    /**
     * 开发者名称
     */
    private String devname;

    /**
     * 开发者密码
     */
    private String devpassword;

    /**
     * 开发者电子邮箱
     */
    private String devemail;

    /**
     * 开发者简介
     */
    private String devinfo;

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