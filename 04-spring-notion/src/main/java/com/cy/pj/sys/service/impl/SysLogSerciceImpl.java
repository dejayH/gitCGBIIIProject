package com.cy.pj.sys.service.impl;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.pojo.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogSerciceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Async
    @Override
    public void saveLog(SysLog entity) {
        String name = Thread.currentThread().getName();
        System.out.println("要的是"+name);
        try{Thread.sleep(3000);}catch (Exception e){}
        sysLogDao.saveLog(entity);
    }

    @Override
    public int deleteById(Long... ids) {
        return sysLogDao.deleteById(ids);
    }


    @Override
    public SysLog selectById(Long id) {
        return sysLogDao.selectById(id);
    }

    @Override
    public List<SysLog> selectLogs(SysLog sysLog) {
        return sysLogDao.selectLogs(sysLog);
    }
}
