package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.cy.pj.common.pojo.Node;
import java.util.List;

@Mapper
public interface SysMenvDao {
    /**
     * 查询所有菜单
     * @return 返回查询到的菜单信息
     */
    List<SysMenu> selectMenus();

    /**
     * 查询树节点信息,在添加或编辑菜单是
     * 会以树结构方式呈现可选的上级菜单
     * @return
     */
    @Select("select id,name,parentId from sys_menus")
    List<Node> selectMeneTreeNodes();

    /**
     * 添加菜单信息
     * @param menu 存储了菜单信息的对象
     * @return 新增的数量
     */
    int insertMenu(SysMenu menu);

    /**
     * 更新菜单信息
     * @param menu
     * @return 更新的数量
     */
    int updateMenu(SysMenu menu);
}
