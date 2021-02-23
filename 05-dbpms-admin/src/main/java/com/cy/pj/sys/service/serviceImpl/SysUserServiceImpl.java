package com.cy.pj.sys.service.serviceImpl;


import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.pojo.SysUser;
import com.cy.pj.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public int validById(Integer id, Integer valid) {
        int rows = sysUserDao.validById(id, valid, "admin");
        if(rows==0) {
            throw new ServiceException("记录可能不存在了");
        }
        return rows;
    }

    @Override
    public List<SysUser> findUsers(SysUser entity) {
        return sysUserDao.selectUser(entity);
    }

    @Override
    public SysUser findById(Integer id) {
        //查询用户以及用户对应的部门信息
        SysUser user = sysUserDao.selectById(id);
        if(user==null) {
            throw new ServiceException("没有找到对应用户id");
        }
        //根据用户id获取角色id
        List<Integer> roles = sysUserRoleDao.selectRoleIdsByUserId(id);
        //将角色id封装到uesr上
        user.setRoleIds(roles);
        return user;
    }

    @Override
    public int saveUser(SysUser entity) {
        //保存用户自身信息
        //1.1对参数进行检验
        //1.2对密码进行加密(MD5盐值加密)
        String password= entity.getPassword();
        String salt = UUID.randomUUID().toString();
        SimpleHash simpleHash = new SimpleHash("MD5",password,salt,1);
        entity.setSalt(salt);
        entity.setPassword(simpleHash.toHex());
        //1.3将用户信息持久化到数据库
        int rows = sysUserDao.insertUser(entity);

        //保存用户和角色关系数据
        sysUserRoleDao.insertUserRoles(entity.getId(), entity.getRoleIds());
        return rows;
    }

    @Override
    public int updateUser(SysUser entity) {
        //更新用户自身信息
        int rows = sysUserDao.updateUser(entity);
        if(rows==0) {
            throw new ServiceException("记录可能已经不存在");
        }
        //更新用户和角色关系数据
        sysUserRoleDao.deletaByUserId(entity.getId());
        sysUserRoleDao.insertUserRoles(entity.getId(), entity.getRoleIds());
        return rows;
    }

}
