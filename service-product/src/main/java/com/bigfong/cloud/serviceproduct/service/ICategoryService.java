package com.bigfong.cloud.serviceproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.cloudcommon.product.Category;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品表
 服务类
 * </p>

 */
public interface ICategoryService extends IService<Category> {
    List<Category> getCategoryList();
}