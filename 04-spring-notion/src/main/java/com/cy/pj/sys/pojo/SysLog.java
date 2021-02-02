package com.cy.pj.sys.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SysLog {
    private Integer id;
    private String ip;
    private String username;
    private String operation;
    private String method;
    private String params;
    private Long time;
    private Integer status;
    private String error;
    private Date createdTime;
}
