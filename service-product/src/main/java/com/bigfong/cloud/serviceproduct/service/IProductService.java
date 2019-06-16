package com.bigfong.cloud.serviceproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;

import java.util.List;

/**
 * <p>
 * 产品表
 服务类
 * </p>

 */
public interface IProductService extends IService<YibaiProduct> {

    Boolean insertOrUpdate(List<YibaiProduct> products);
}