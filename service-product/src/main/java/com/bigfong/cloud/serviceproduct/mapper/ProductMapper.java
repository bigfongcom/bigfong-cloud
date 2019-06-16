package com.bigfong.cloud.serviceproduct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * <p>
 * 产品表
 Mapper 接口
 * </p>
 */
public interface ProductMapper extends BaseMapper<YibaiProduct> {

    YibaiProduct getProductBySku(String sku);

    YibaiProduct getProductByProductId(Integer product_id);

    Integer insertProduct(@Param("item") YibaiProduct product);

    Integer updateProduct(@Param("item") YibaiProduct product);
}
