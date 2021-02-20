package com.cy.pj.sys.service;

import com.cy.pj.sys.pojo.SysUser;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

/**
 * 定义用户业务接口,负责用户业务逻辑规范定义
 */
public interface SysUserService {

    /**
     * 基于用户id修改用户状态(0,1)
     * @param id
     * @param valid
     * @return
     */
    int validById(Integer id, Integer valid);

    /**
     * 查询用户信息
     * @param entity
     * @return
     */
    List<SysUser> findUsers(SysUser entity);

    /**
     * 基于id查询用户信息
     * @param id
     * @return
     */
    SysUser findById(Integer id);

    /**
     * 添加新的用户消息以及用户和角色关系数据
     * @param entity
     * @return
     */
    int saveUser(SysUser entity);

    /**
     * 更新用户消息以及用户和角色关系数据
     * @param entity
     * @return
     */
    int updateUser(SysUser entity);


}
