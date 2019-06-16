package com.bigfong.cloud.servicedata.controller;

import com.bigfong.cloud.cloudcommon.base.Code;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import com.bigfong.cloud.servicedata.entity.product.YibaiProductMap;
import com.bigfong.cloud.servicedata.service.product.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 * 产品表
 前端控制器
 * </p>

 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private IProductService productService;


    /**
     * 分页获取SKU相关信息
     * @Author:    jom
     * @param      pageNumber,pageSize,productStatus,sku
     * @return     ResponseMsg
     * @date       2019/03/28
     */
    @GetMapping("/selectProductPage/{pageSize}/{pageNumber}")
    public ResponseMsg selectProductPage(@PathVariable(value = "pageSize") Integer pageSize,@PathVariable(value = "pageNumber") Integer pageNumber){
        try {
            List<YibaiProductMap> products = productService.selectProductPage(pageNumber,pageSize);
            return new ResponseMsg(Code.SUCCESS,products,"查询成功");
        }catch (Exception e){
            logger.error("YibaiProductController.selectProductPage: "  + e);
            return new ResponseMsg(Code.OTHER,null,"查询失败==》" + e.getMessage());
        }
    }


    /**
     * 分页获取SKU相关信息
     * @Author:    jom
     * @param      pageNumber,pageSize,productStatus,sku
     * @return     ResponseMsg
     * @date       2019/03/28
     */
    @GetMapping("/getProductList/{pageSize}/{pageNumber}")
    public ResponseMsg getProductList(@PathVariable(value = "pageSize") Integer pageSize,@PathVariable(value = "pageNumber") Integer pageNumber){
        try {
            List<YibaiProduct> products = productService.getProductList(pageNumber,pageSize);
            return new ResponseMsg(Code.SUCCESS,products.size(),"查询成功");
        }catch (Exception e){
            logger.error("YibaiProductController.getProductList: "  + e);
            return new ResponseMsg(Code.OTHER,null,"查询失败==》" + e.getMessage());
        }
    }

}
