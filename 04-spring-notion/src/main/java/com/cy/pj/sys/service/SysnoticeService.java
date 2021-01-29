package com.cy.pj.sys.service;

import com.cy.pj.sys.dao.SysNotice;
import com.cy.pj.sys.pojo.pojoSysNotice;

import java.util.List;

public interface SysnoticeService {
    /**
     * 新增通告信息
     *
     * @param notice
     * @return
     */
    int saveNotice(pojoSysNotice notice);

    /**
     * 基于条件查询通告信息
     *
     * @param notice
     * @return
     */
    List<pojoSysNotice> findNotices(pojoSysNotice notice);

    /**
     * 基于通告删除通告信息
     *
     * @param ids
     * @return
     */
    int deleteById(Long... ids);

    /**
     * 基于id查询某条通告
     *
     * @param id
     * @return
     */
    pojoSysNotice findById(Long id);

    /**
     * 更新通告信息
     *
     * @param notice
     * @return
     */
    int updateNotice(pojoSysNotice notice);

}
