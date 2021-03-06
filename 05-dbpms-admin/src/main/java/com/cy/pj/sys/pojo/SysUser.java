package com.cy.pj.sys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户对象设计及实现
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1337911850311626879L;
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String mobile;
    private String email;
    /**
     * 默认为有效状态,0 代表无效
     */
    private Integer valid = 1;
    private Integer deptId;
    private String deptName;
    /**
     * 用户拥有的id
     */
    private List<Integer> roleIds;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
}
