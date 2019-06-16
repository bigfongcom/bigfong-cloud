package com.bigfong.cloud.servicedata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import com.bigfong.cloud.servicedata.entity.product.YibaiProductMap;

import java.util.List;


/**
 * <p>
 * 产品表
 Mapper 接口
 * </p>
 */
public interface ProductMapper extends BaseMapper<YibaiProduct> {

    Integer getProductCount();
    List<YibaiProductMap> selectProductPage(Page page);

    List<YibaiProduct> getProductList(Page<YibaiProduct> page);
}
