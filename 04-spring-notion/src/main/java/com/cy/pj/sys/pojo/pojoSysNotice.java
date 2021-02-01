package com.cy.pj.sys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//@Setter
//@Getter
//@ToString
@Data
public class pojoSysNotice {
    private static final long serialVersionUID = 1L;
    /**
     * 公告 ID
     */
    private Long id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告类型（1 通知 2 公告）
     */
    private String type;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 公告状态（0 正常 1 关闭）
     */
    private String status;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")//默认
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;
    /**
     * 创建用户
     */
    private String createdUser;
    /**
     * 修改用户
     */
    private String modifiedUser;
    /**
     * 备注
     */
    private String remark;


}
