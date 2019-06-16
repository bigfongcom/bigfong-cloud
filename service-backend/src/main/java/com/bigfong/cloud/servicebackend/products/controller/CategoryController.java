package com.bigfong.cloud.servicebackend.products.controller;

import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.cloudcommon.product.Category;
import com.bigfong.cloud.servicebackend.common.exception.GlobalException;
import com.bigfong.cloud.servicebackend.products.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ResponseMsg getList() {
        try {
            List<Category> list = categoryService.getCategoryList();
            return ResponseMsg.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(e.getMessage());
        }


    }
}
