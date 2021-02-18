package com.cy.pj.sys.service.serviceImpl;

import com.cy.pj.common.pojo.CheckBox;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.pojo.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public List<SysRole> findRoles(SysRole entity) {
        return sysRoleDao.selectRoles(entity);
    }

    @Override
    public int saveRole(SysRole entity) {
        //保存角色自身信息
        int rows = sysRoleDao.insertRole(entity);
        //保存角色菜单关系数据
        sysRoleMenuDao.insertRoleMenus(entity.getId(), entity.getMenuIds());
        return rows;
    }

    @Override
    public SysRole findById(Integer id) {
        return sysRoleDao.selectById(id);
    }

    @Override
    public int updateRole(SysRole entity) {
        //保存角色自身信息
        int rows = sysRoleDao.updateRole(entity);
        //保存角色菜单关系数据
        sysRoleMenuDao.deleteByRoleId(entity.getId());
        sysRoleMenuDao.insertRoleMenus(entity.getId(), entity.getMenuIds());
        return rows;
    }

    @Override
    public List<CheckBox> findCheckRoles() {
        return null;
    }
}
