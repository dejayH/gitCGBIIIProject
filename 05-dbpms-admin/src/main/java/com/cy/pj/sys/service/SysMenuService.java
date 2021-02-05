package com.cy.pj.sys.service;

import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.pojo.SysMenu;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SysMenuService {
    /**查询所有菜单信息*/
    List<SysMenu> findMenus();
    /**新增菜单*/
    int saveMenu(SysMenu entity);
    /**更新菜单*/
    int updateMenu(SysMenu entity);
    /**查找菜单树节点信息*/
    List<Node> findMenuTreeNodes();

}
