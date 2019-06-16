package com.bigfong.cloud.servicedata.service.product.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import com.bigfong.cloud.servicedata.common.DBTypeEnum;
import com.bigfong.cloud.servicedata.common.DataSourceSwitch;
import com.bigfong.cloud.servicedata.entity.product.YibaiProductMap;
import com.bigfong.cloud.servicedata.feign.ProductFeignClient;
import com.bigfong.cloud.servicedata.jobhandler.ProductJobHandler;
import com.bigfong.cloud.servicedata.mapper.ProductMapper;
import com.bigfong.cloud.servicedata.service.product.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, YibaiProduct> implements IProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductFeignClient productFeignClient;

    @DataSourceSwitch(DBTypeEnum.product)
    @Override
    public List<YibaiProductMap> selectProductPage(Integer pageNumber, Integer pageSize) {
        Page page = new Page(pageNumber,pageSize);
        List<YibaiProductMap> yibaiProducts = productMapper.selectProductPage(page);

        return yibaiProducts;
    }

    @Override
    public List<YibaiProduct> getProductList(Integer pageNumber, Integer pageSize) {
        Page<YibaiProduct> page = new Page<>(pageNumber,pageSize);
        List<YibaiProduct> productList = productMapper.getProductList(page);

        //跨服务调用产品模块系统接口，推送数据,不需要等待返回结果
        ResponseMsg res = productFeignClient.getProductList(productList);

        return productList;
    }

    @Override
    public Integer getProductCount() {
        return productMapper.getProductCount();
    }

}
