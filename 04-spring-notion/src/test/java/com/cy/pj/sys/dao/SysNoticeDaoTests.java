package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.pojoSysNotice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SysNoticeDaoTests {
    @Autowired
    private SysNotice sysNotice;

    @Test
    void testInsertNotice(){
        pojoSysNotice notice = new pojoSysNotice();
        notice.setTitle("CGB2011");
        notice.setContent("2021/3");
        notice.setStatus("0");
        notice.setType("1");
        notice.setCreatedUser("tony");
        notice.setModifiedUser("tony");
        sysNotice.insertNotice(notice);

    }
}
