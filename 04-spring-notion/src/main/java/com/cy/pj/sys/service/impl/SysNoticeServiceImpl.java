package com.cy.pj.sys.service.impl;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.annotation.RequiredTime;
import com.cy.pj.sys.dao.SysNotice;
import com.cy.pj.sys.pojo.pojoSysNotice;
import com.cy.pj.sys.service.SysnoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysNoticeServiceImpl implements SysnoticeService {


    private static final Logger logger = LoggerFactory.getLogger(SysNoticeServiceImpl.class);

    @Autowired
    private SysNotice sysNotice;

    @RequiredLog(operation = "新增公告信息")
    @Override
    public int saveNotice(pojoSysNotice notice) {
        int rows = sysNotice.insertNotice(notice);
        return rows;
    }

    @RequiredLog(operation = "查询公告列表")
    @Override
    public List<pojoSysNotice> findNotices(pojoSysNotice notice) {
        logger.debug("start:{}", System.currentTimeMillis());
        List<pojoSysNotice> list = sysNotice.selectNotices(notice);
        logger.debug("end:{}", System.currentTimeMillis());
        return list;
    }

    @Override
    public int deleteById(Long... ids) {
        int rows = sysNotice.deleteById(ids);
        return rows;
    }

    @RequiredTime
    @Override
    public pojoSysNotice findById(Long id) {
        pojoSysNotice Notice = sysNotice.selectById(id);
        return Notice;
    }

    @Override
    public int updateNotice(pojoSysNotice notice) {
        int rows = sysNotice.updateNotice(notice);
        return rows;
    }
}
