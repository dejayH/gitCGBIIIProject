package com.cy.pj.sys.service;


import com.cy.pj.sys.pojo.SysLog;

import java.util.List;

public interface SysLogService {
    void saveLog(SysLog entity);

    int deleteById(Long... ids);

    SysLog selectById(Long id);

    List<SysLog> selectLogs(SysLog sysLog);
}

