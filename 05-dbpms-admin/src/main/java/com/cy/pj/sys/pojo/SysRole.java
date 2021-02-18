package com.cy.pj.sys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID = 2616887221667632152L;
    /**角色id*/
    private Integer id;
    /**角色名字*/
    private String name;
    /**菜单id*/
    private Integer[] menuIds;
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
