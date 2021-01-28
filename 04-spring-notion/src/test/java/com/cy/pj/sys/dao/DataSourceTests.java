package com.cy.pj.sys.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @springBootTest 注解描述的类
 * 为springboot中的单元测试类
 */

@SpringBootTest
public class DataSourceTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void testGetConnection() throws SQLException {
        Connection coon = dataSource.getConnection();
        System.out.println("coon=" + coon);
    }

    @Test
    void testSaveNotice01() throws SQLException {//homework (通过此方法基于jdbc向数据库写入一条数据)
        //JDBC (是java中推出的连接数据库的一组API,是规范)
        //数据库厂商提供JDBC驱动(jdbc规范的实现)负责实现数据库的操作.
        //1.建立连接 (负责与数据库进行通讯)
        Connection conn = dataSource.getConnection();
        //2.创建statement(sql传送器->负责与将sql发送到数据库端)
        String sql = "insert into sys_notice " +
                " (title,content,type,status,createdTime,createdUser,modifiedTime,modifiedUser) " +
                "  values ('加课通知','本周六加课','1','0',now(),'tony',now(),'tony') ";
        Statement stmt = conn.createStatement();
        //3.发送sql
        stmt.execute(sql);
        //4.处理结果
        //5.释放资源(后续释放资源要写到finally代码块中)
        stmt.close();
        conn.close();//将连接返回池中
    }

    @Test
    void testSaveNotice02() throws SQLException {
        //1.建立连接(负责与数据库进行通讯)
        Connection conn = dataSource.getConnection();
        //2.创建statement(sql->负责将sql发送到数据库端
        String sql = "INSERT  INTO sys_notice (title,content,type,status,createdTime,createdUser,modifiedTime,modifiedUser)" +
                "value (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        //3.发送sql
        stmt.setString(1, "开学通知");
        stmt.setString(2, "2021年3月18号开学");
        stmt.setString(3, "1");
        stmt.setString(4, "0");
        stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
        stmt.setString(6, "jason");
        stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
        stmt.setString(8, "Tony");
        stmt.execute();
        //4.释放资源
        stmt.close();
        conn.close();
    }

    @Test
    void testSelectNotion() throws SQLException {
        Connection conn = dataSource.getConnection();
        String sql = "SELECT id,title,content,status,type from sys_notice where id>=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 2);
        boolean flag = pstmt.execute();
        if (flag) {
            ResultSet rs = pstmt.getResultSet();
            List<Map<String,Object>> list = new ArrayList<>();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                Map<String,Object> map = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    map.put(rsmd.getColumnLabel(i),rs.getObject(rsmd.getColumnLabel(i)));
                }
//                map.put("id",rs.getInt("id"));
//                map.put("title",rs.getString("title"));
//                map.put("content",rs.getString("content"));
//                map.put("type",rs.getString("type"));
//                map.put("createdTime",rs.getTime("createdTime"));
                list.add(map);
            }
            for (Map<String, Object> t : list) {
                System.out.println(t);
            }
            rs.close();
        }
        pstmt.close();
        conn.close();
    }
}
