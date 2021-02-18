package com.cy.pj.sys.dao;

import com.cy.pj.common.pojo.CheckBox;
import com.cy.pj.sys.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*角色相关数据*/
@Mapper
public interface SysRoleDao {
    /**
     * 基于条件查询角色信息
     * @param role 查询条件
     * @return 查询结果
     */
    List<SysRole> selectRoles(SysRole role);

    /**
     * 基于id查找对应的角色和角色对应的菜单信息
     * @param id
     * @return 查询到的角色对象
     */
    SysRole selectById(Integer id);

    /**
     * 新增角色信息
     * @param entity 新增的角色的信息
     * @return 新增的信息的数量
     */
    int insertRole(SysRole entity);

    /**
     * 查询角色id和角色名字
     * 每行记录封装为一个CheckBox对象
     * 后续在为用户分配角色时会用到
     * @return
     */
    @Select("SELECT id,name FROM sys_roles")
    List<CheckBox> selectCheckRoles();

    /**
     * 更新角色信息
     * @param entity
     * @return
     */
    int updateRole(SysRole entity);
}
