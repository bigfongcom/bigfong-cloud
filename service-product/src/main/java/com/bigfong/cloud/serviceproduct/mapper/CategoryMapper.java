package com.bigfong.cloud.serviceproduct.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigfong.cloud.cloudcommon.product.Category;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> selectAll();
}
