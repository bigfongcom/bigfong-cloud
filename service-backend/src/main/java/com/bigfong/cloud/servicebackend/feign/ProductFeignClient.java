package com.bigfong.cloud.servicebackend.feign;

import com.alibaba.fastjson.JSONObject;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "SERVICE-PRODUCT")
@FeignClient(name = "SERVICE-PRODUCT",fallback = ProductFeignHystrix.class)
public interface ProductFeignClient {


    @PostMapping("/feign/getCategoryList")
    public ResponseMsg getCategoryList(@RequestBody(required = false) JSONObject jsonObject);

}
