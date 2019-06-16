package com.bigfong.cloud.serviceproduct.controller;

import com.alibaba.fastjson.JSONObject;
import com.bigfong.cloud.cloudcommon.base.Code;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.cloudcommon.product.Category;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import com.bigfong.cloud.serviceproduct.service.ICategoryService;
import com.bigfong.cloud.serviceproduct.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName FeignController
 * @Description 各个系统跨服务调用的接口
 **/

@RestController
@RequestMapping("/feign")
public class FeignController {
    private static Logger logger = LoggerFactory.getLogger(FeignController.class);

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/getProductList")
    public ResponseMsg getProductList(@RequestBody List<YibaiProduct> products) {
        logger.info("==============getProductList==============");
        Boolean flag = productService.insertOrUpdate(products);
        return new ResponseMsg(Code.SUCCESS,"获取推送过来的产品信息成功！");
    }

    @PostMapping("/getCategoryList")
    public ResponseMsg getCategoryList(@RequestBody(required=false) JSONObject jsonObject) {
        logger.info("==============getCategoryList==============");
        List<Category> categoryList = categoryService.getCategoryList();
        return ResponseMsg.success(categoryList);
    }
}
