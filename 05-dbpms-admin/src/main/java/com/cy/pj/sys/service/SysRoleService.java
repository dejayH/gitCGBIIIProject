package com.cy.pj.sys.service;

import com.cy.pj.common.pojo.CheckBox;
import com.cy.pj.sys.pojo.SysRole;

import java.util.List;

public interface SysRoleService {
    /**
     * 基于条件查询角色信息
     *
     * @param entity 封装了查询条件的对象
     * @return 查询到的角色信息
     */
    List<SysRole> findRoles(SysRole entity);

    /**
     * 新增角色以及角色对应的菜单关系数据
     *
     * @param entity 封装了角色信息的对象
     * @return 新增的角色信息的数量
     */
    int saveRole(SysRole entity);

    /**
     * 基于角色id查询角色以及角色对应菜单关系数据
     *
     * @param id
     * @return 角色的信息
     */
    SysRole findById(Integer id);

    /**
     * 基于角色id 更新角色以及角色对应的菜单信息
     *
     * @param entity 封装了角色信息的对象
     * @return 更新了角色信息的数量
     */
    int updateRole(SysRole entity);

    /**
     * 为用户授权时,查询课授权的角色
     *
     * @return
     */
    List<CheckBox> findCheckRoles();
}
