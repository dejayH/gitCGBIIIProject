package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author uid
 */
@Mapper
public interface SysRoleMenuDao {

    /**
     * 新增角色菜单关系数据
     * @param roleId 角色的id
     * @param menuIds 角色菜单的id
     * @return 行数
     */
    void insertRoleMenus(Integer roleId, Integer[] menuIds);

    /**
     * 基于角色ID删除角色和菜单关系数据
     * @param roleId 角色id
     * @return 数量
     */
    @Delete("DELETE FROM sys_role_menus WHERE role_id=#{roleId}")
    int deleteByRoleId(Integer roleId);

}
