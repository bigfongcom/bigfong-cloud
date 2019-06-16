package com.bigfong.cloud.servicebackend.feign;

import com.alibaba.fastjson.JSONObject;
import com.bigfong.cloud.cloudcommon.base.Code;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.cloudcommon.product.Category;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class ProductFeignHystrix implements ProductFeignClient {
    @Override
    public ResponseMsg getCategoryList(@RequestBody(required = false) JSONObject jsonObject) {
        return new ResponseMsg(Code.SERVICE_HAS_FAIL);
    }

}
