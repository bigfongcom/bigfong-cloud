package com.bigfong.cloud.scheduserver;

import com.bigfong.cloud.scheduserver.task.async.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes={ScheduServerApplication.class})// 指定启动类
//@SpringApplicationConfiguration(classes = Application.class)// 1.4.0 前版本
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private Task task;

     @Test
    public void testOne(){
        System.out.println("test hello 1");
    }

    @Test
    public void testTwo()throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }

    @Before
    public void testBefore(){
        System.out.println("before");
    }

    @After
    public void testAfter(){
        System.out.println("after");
    }
}