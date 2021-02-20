package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**负责用户数据范围逻辑规范的定义*/
@Mapper
public interface SysUserDao {
    /**
     * 基于用户名查询用户信息(登录时需要)
     * @param username
     * @return
     */
    SysUser selectUserByUsername(String username);

    /**
     * 基于id查找用户信息
     * @param id
     * @return
     */
    SysUser selectById(Integer id);

    /**
     * 查询用户及对应的部门相关信息
     * @param entity 封装了查询条件的对象
     * @return 查询到的用户信息
     */
    List<SysUser> selectUser(SysUser entity);

    /**
     * 修改用户权限状态
     * @param id 用户的id
     * @param valid 状态信息(0,1)
     * @param modifiedUser 状态的修改者
     * @return 修改的状态数量
     */
    int validById(Integer id,Integer valid,String modifiedUser);

    /**
     * 保存用户信息
     * @param entity
     * @return
     */
    int insertUser(SysUser entity);

    /**
     * 更新用户信息
     * @param entity
     * @return
     */
    int updateUser(SysUser entity);
}
