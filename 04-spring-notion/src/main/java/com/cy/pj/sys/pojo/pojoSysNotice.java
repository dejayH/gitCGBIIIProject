package com.cy.pj.sys.pojo;

import java.util.Date;

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
     * */
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    //自己添加 set/get/toString 方法

    @Override
    public String toString() {
        return "SysNotice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
}
