package com.cy.pj.sys.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cy.pj.sys.pojo.pojoSysNotice;

@SpringBootTest
public class SysNoticeServiceTsets {

    @Autowired
    private SysnoticeService sysnoticeService;

    @Test
    void testFindNotices(){
        pojoSysNotice notice = new pojoSysNotice();
        notice.getId();
        notice.setType("1");
        notice.setModifiedUser("tony");
        sysnoticeService.findNotices(notice);

    }
}
