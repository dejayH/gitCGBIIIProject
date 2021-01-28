package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.pojoSysNotice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysNotice {

    /**
     * 新增信息
     * */
    int insertNotice(pojoSysNotice notice);

    /**
     * 基于id查询notice信息
     * @param id 查询条件
     * @return 查询到的notice对象(存储表中的一行记录)
     * */
    @Select("select * from sys_notice where id=#{id}")
    pojoSysNotice selectById(Integer id);

    /**
     * 更新对象
     * */
    int updateNotice(pojoSysNotice notice);

    /**
     * 删除对象
     * */
//    int deleteById(@Param("ids") Long... ids);
    int deleteById(Long... ids);
}
