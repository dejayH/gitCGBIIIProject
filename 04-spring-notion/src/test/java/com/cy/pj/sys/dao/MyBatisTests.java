package com.cy.pj.sys.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

@SpringBootTest
public class MyBatisTests {

    @Autowired
    private SqlSession SqlSession;

    @Test
    void testGetConnection(){
        Connection conn = SqlSession.getConnection();
        System.out.println("conn="+conn);
    }

}
