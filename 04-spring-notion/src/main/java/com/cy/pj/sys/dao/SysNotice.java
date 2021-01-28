package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.pojoSysNotice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysNotice {
    int insertNotice(pojoSysNotice notice);
}
