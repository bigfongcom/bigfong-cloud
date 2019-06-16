package com.bigfong.cloud.servicerabbimq;

import com.bigfong.cloud.servicerabbitmq.receive.InsertProductReceive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Autowired
   // private InsertProductReceive insertProductReceive;

    @Test
    public void countByDay()throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "2016-06-03 02:35:41";
        Integer accountId = 14;
        String sku = "ZY-GP9-001";
        Date startDate = sdf.parse(str);
        Date endDate = new Date();
//        Long count = orderAmazonService.countNumberByDay(accountId, sku, startDate, endDate);
//        System.out.println("count ==============>" + count);
    }
}
