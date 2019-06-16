package com.bigfong.cloud.servicebackend.products.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.cloudcommon.product.Category;
import com.bigfong.cloud.servicebackend.feign.ProductFeignClient;
import com.bigfong.cloud.servicebackend.products.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 产品表
 服务实现类
 * </p>
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public List<Category> getCategoryList() throws RuntimeException {
        JSONObject jsonObject = new JSONObject();
        ResponseMsg res =  productFeignClient.getCategoryList(jsonObject);
        if (res.getCode()==200){
            return (List<Category>) res.getData();
        }else{
            throw new RuntimeException(res.getMsg());
        }
    }

}
