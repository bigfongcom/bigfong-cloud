package com.bigfong.cloud.servicedata.feign;

import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@FeignClient(name = "service-goods")
@FeignClient(value = "service-goods",fallback = ProductFeignHystrix.class)
public interface ProductFeignClient {


    @PostMapping("/feign/getProductList")
    public ResponseMsg getProductList(@RequestBody List<YibaiProduct> products);

}
