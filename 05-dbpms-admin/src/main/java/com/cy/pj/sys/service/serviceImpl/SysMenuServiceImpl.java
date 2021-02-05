package com.cy.pj.sys.service.serviceImpl;

import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.pojo.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Override
    public List<SysMenu> findMenus() {
        return sysMenuDao.selectMenus();
    }

    /**
     * 新增菜单
     * @param entity
     * @return
     */
    @Override
    public int saveMenu(SysMenu entity) {
        return sysMenuDao.insertMenu(entity);
    }

    @Override
    public int updateMenu(SysMenu entity) {
        return sysMenuDao.updateMenu(entity);
    }

    @Override
    public List<Node> findMenuTreeNodes() {
        return sysMenuDao.selectMeneTreeNodes();
    }
}
