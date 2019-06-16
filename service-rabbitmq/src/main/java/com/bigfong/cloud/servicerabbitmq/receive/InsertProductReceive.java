package com.bigfong.cloud.servicerabbitmq.receive;

import com.alibaba.fastjson.JSON;
import com.bigfong.cloud.servicerabbitmq.utils.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InsertProductReceive {
    private static Logger logger = LoggerFactory.getLogger(InsertProductReceive.class);

    @Value("${ebuy.push-product-to-yun-purchase.url}")
    private String pushProductToYunPurchaseUrl;

    @RabbitListener(queues = "${ebuy.erp-products-insertproduct.mq.queue.name}")    //监听器监听指定的Queue
    public void processC(String str) throws UnsupportedEncodingException {
        //System.out.println("Receive:"+str);

        String jsonStr = URLDecoder.decode(str, "utf-8");
        if (JsonUtil.isJson(jsonStr)) {
            try {
                List<Map> list = JsonUtil.jsonToList(jsonStr, Map.class);
                Map<String, Map> mapList = new HashMap<>(list.size());
                for (Map map : list) {
                    mapList.put(map.get("sku").toString(), map);
                }

                List<NameValuePair> params = new ArrayList<>();
                NameValuePair purchaseInfo = new BasicNameValuePair("ProductToPurchaseInfo", JSON.toJSONString(mapList));
                params.add(purchaseInfo);

                this.doPost(pushProductToYunPurchaseUrl,params);

                this.doPost("http://127.0.0.1/productTest.php",params);

            } catch (Exception ex) {
                logger.error("向新采购系统推送数据时异常", ex);
            }
        }
    }

    private void doPost(String url , List<NameValuePair> params) throws IOException{
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        String s = "";

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
            HttpResponse response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                s = EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        System.out.println(s);
    }

}