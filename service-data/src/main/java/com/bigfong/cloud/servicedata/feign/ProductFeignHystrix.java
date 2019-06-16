package com.bigfong.cloud.servicedata.feign;

import com.bigfong.cloud.cloudcommon.base.Code;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class ProductFeignHystrix implements ProductFeignClient {
    @Override
    public ResponseMsg getProductList(List<YibaiProduct> products) {
        return new ResponseMsg(Code.SERVICE_HAS_FAIL);
    }

    /*@Override
    public String hello(@RequestParam(value = "name") String name) {
        return "sorry "+name+"，service has fail!";
    }*/
}
