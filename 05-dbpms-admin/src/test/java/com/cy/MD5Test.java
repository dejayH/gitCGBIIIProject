package com.cy;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class MD5Test {
    /**
     * 测试MD5的作用原理
     */
    @Test
    void MD5Test1(){
        String password="123456";
        String salt = UUID.randomUUID().toString();
        SimpleHash md5 = new SimpleHash("MD5", password,salt);
        password=md5.toHex();
        System.out.println(password);

    }
}
