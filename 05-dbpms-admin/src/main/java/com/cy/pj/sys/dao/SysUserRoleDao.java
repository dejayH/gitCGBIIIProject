package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserRoleDao {

    /**
     * 基于用户id查询角色id
     * @param userId
     * @return
     */
    List<Integer> selectRoleIdsByUserId(Integer userId);

    /**
     * 新增用户和角色关系
     * @param userId
     * @param roleIds
     * @return
     */
    int insertUserRoles(Integer userId, List<Integer> roleIds);

    /**
     * 基于用户id删除用户和角色关系数据
     * @param userId
     * @return
     */
    int deletaByUserId(Integer userId);
}
