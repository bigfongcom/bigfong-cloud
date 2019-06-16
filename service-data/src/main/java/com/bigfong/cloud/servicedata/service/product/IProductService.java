package com.bigfong.cloud.servicedata.service.product;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import com.bigfong.cloud.servicedata.entity.product.YibaiProductMap;

import java.util.List;

/**
 * <p>
 * 产品表
 服务类
 * </p>

 */
public interface IProductService extends IService<YibaiProduct> {

    List<YibaiProductMap> selectProductPage(Integer pageNumber, Integer pageSize);

    List<YibaiProduct> getProductList(Integer pageNumber, Integer pageSize);

    Integer getProductCount();
}