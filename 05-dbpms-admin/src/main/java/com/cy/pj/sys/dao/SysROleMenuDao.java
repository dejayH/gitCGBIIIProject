package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysROleMenuDao {

    /**
     * 新增角色菜单关系数据
     * @param roleId 角色的id
     * @param menuIds 角色菜单的id
     * @return
     */
    int insertRoleMenu(Integer roleId,Integer[] menuIds);
}
