package com.bigfong.cloud.serviceproduct.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.cloudcommon.base.ResponseMsg;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import com.bigfong.cloud.serviceproduct.common.DBTypeEnum;
import com.bigfong.cloud.serviceproduct.common.DataSourceSwitch;
import com.bigfong.cloud.serviceproduct.mapper.ProductMapper;
import com.bigfong.cloud.serviceproduct.service.IProductService;
import org.apache.commons.lang.StringUtils;
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

    @Autowired
    private ProductMapper productMapper;


    @DataSourceSwitch(DBTypeEnum.basic)
    @Override
    public Boolean insertOrUpdate(List<YibaiProduct> products) {
        boolean isSuccess = false;
        for (YibaiProduct product:products) {
            String sku = product.getSku();
            if (StringUtils.isNotEmpty(sku)){
                YibaiProduct productInfo = productMapper.getProductBySku(sku);
                //已经存在
                if (productInfo==null){
                    int addRow = productMapper.insertProduct(product);
                    if(addRow > 0){
                        isSuccess = true;
                    }
                }else{
                    int upRow = productMapper.updateProduct(product);
                    if(upRow > 0){
                        isSuccess = true;
                    }
                }
            }
        }

        return isSuccess;
    }

}
