package com.cy.pj.sys.dao;

import com.cy.pj.sys.pojo.pojoSysNotice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysNoticeDaoTests {
    @Autowired
    private SysNotice sysNotice;

    @Test
    void testInsertNotice() {
        pojoSysNotice notice = new pojoSysNotice();
        notice.setTitle("CGB2011");
        notice.setContent("2021/3");
        notice.setStatus("0");
        notice.setType("1");
        notice.setCreatedUser("tony");
        notice.setModifiedUser("tony");
        sysNotice.insertNotice(notice);
    }

    @Test
    void testSelectById() {
        pojoSysNotice sys = sysNotice.selectById(1L);
        System.out.println(sys);
    }

    @Test
    void testUpdateNotice() {
        pojoSysNotice n = sysNotice.selectById(1L);
        n.setType("2");
        n.setContent("放假");
        n.setModifiedUser("timy");
        sysNotice.updateNotice(n);
    }

    @Test
    void testDeleteById() {
        int i = sysNotice.deleteById();
        System.out.println("rows=" + i);
    }

    @Test
    void testSelectNotices(){
        pojoSysNotice no = new pojoSysNotice();
        no.setType("2");
        no.setTitle("放假");
        List<pojoSysNotice> list = sysNotice.selectNotices(no);
        for (pojoSysNotice l : list) {
            System.out.println(l);
        }

    }
}
