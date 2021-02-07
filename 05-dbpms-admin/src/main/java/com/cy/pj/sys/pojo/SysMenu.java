package com.cy.pj.sys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 5834588545320702247L;
    /**菜单id*/
    private Integer id;
    /**菜单名称*/
    private String name;
    /**菜单类型*/
    private Integer type;
    /**菜单的url*/
    private String url;
    /**上级菜单的ID*/
    private Integer parentId;
    /**上级菜单的名称*/
    private String parentName;
    /**菜单排序号*/
    private Integer sort;
    /**菜单授权标识*/
    private String permission;
    /**备注*/
    private String remark;
    /**创建的时间*/
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    /**更新的时间*/
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date modifiedTime;
    /**创建者*/
    private String createdUser;
    /**修改者*/
    private String modifiedUser;

}
