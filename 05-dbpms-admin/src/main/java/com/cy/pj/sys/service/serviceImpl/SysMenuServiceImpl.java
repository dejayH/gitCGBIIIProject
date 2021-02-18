package com.cy.pj.sys.service.serviceImpl;

import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.pojo.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;

    /**
     * 查询所有菜单
     * @return
     */
//    @Cacheable(value="sysMenu",key = "'selectMenus'")
    @Cacheable("sysMenu")//缓存应用的切入点方法(底层aop)
    @Override
    public List<SysMenu> findMenus() {
        return sysMenuDao.selectMenus();
    }

    /**
     * 新增菜单
     * @param entity
     * @return
     */
//    @CacheEvict(value="sysMenu",key = "'selectMenus'")
    @CacheEvict(value="sysMenu",allEntries = true)
    @Override
    public int saveMenu(SysMenu entity) {
        return sysMenuDao.insertMenu(entity);
    }

    /**
     * 更新菜单信息
     * @param entity
     * @return
     */
//    @CacheEvict(value="sysMenu",key = "'selectMenus'")
    @CacheEvict(value="sysMenu",allEntries = true)
    @Override
    public int updateMenu(SysMenu entity) {
        return sysMenuDao.updateMenu(entity);
    }

    /**
     * 查询菜单树
     * @return
     */
    @Override
    public List<Node> findMenuTreeNodes() {
        return sysMenuDao.selectMeneTreeNodes();
    }
}
