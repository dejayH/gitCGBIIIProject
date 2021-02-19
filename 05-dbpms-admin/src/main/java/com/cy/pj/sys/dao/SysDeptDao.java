package com.cy.pj.sys.dao;


import com.cy.pj.common.pojo.Node;
import com.cy.pj.sys.pojo.SysDept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysDeptDao {
      /**
               * 查询所有部门以及部门的上级菜单信息
       * @return
       */
	  @Select("select c.*,p.name parentName from sys_depts c left join sys_depts p on c.parentId=p.id")
	  List<Map<String,Object>> selectDepts();
	  
	  @Select("select id,name,parentId from sys_depts")
	  List<Node> selectDeptTreeNodes();
	  
	  int updateMenu(SysDept entity);
	  int insertMenu(SysDept entity);
}







