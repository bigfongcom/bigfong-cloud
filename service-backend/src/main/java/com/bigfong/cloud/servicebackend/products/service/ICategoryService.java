package com.bigfong.cloud.servicebackend.products.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.cloudcommon.product.Category;
import com.bigfong.cloud.servicebackend.common.exception.GlobalException;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品表
 服务类
 * </p>

 */
public interface ICategoryService {
    List<Category> getCategoryList() throws RuntimeException;
}