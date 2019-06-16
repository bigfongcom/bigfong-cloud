package com.bigfong.cloud.servicerabbimq;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class TestPedEnc {
    @Autowired
    StringEncryptor stringEncryptor;//密码解码器自动注入
    @Value("${spring.datasource.passWord}")
    private String password;
    @Value("${spring.datasource.userName}")
    private String username;


    @Test
    public void Test1 (){
        System.out.println("数据库链接密码"+username);
        System.out.println("数据库链接密码"+password);
    }
}
