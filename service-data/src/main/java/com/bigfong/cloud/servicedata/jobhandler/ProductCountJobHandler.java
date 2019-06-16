package com.bigfong.cloud.servicedata.jobhandler;


import com.bigfong.cloud.servicedata.common.DateUtils;
import com.bigfong.cloud.servicedata.service.basic.ISysConfigService;
import com.bigfong.cloud.servicedata.service.product.IProductService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigfong.cloud.servicedata.common.CloudConstants;

import java.util.Date;

/**
 * 获取产品数量
 */
@JobHandler(value = "productCountJobHandler")
@Component
public class ProductCountJobHandler extends IJobHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCountJobHandler.class);



    @Autowired
    private IProductService productService;

    @Autowired
    private ISysConfigService sysConfigService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        LOGGER.info(">>>>>>>>>>> ProductCountJobHandler-execute");

        if (StringUtils.isNotEmpty(param)) {
            boolean flag = false;
            //判断是否在指定星期内,xxl-job cron   0 0/10 9-19 0 0 1/5 *报不合法
            Date today = new Date();
            Integer dayNum = DateUtils.getWeekOfDate(today);
            String[] params = param.split(",");
            for (String s : params) {
                if (dayNum == Integer.parseInt(s)) {
                    flag = true;
                }
            }

            if (!flag) {
                return SUCCESS;
            }

            try {
                Integer count = productService.getProductCount();
                if (count>0){
                    sysConfigService.updateInfo(CloudConstants.SYSCONFIG_PRODUCT_COUNT,count+"");
                }
                LOGGER.info(">>>>>>>>>>> productJobHandler-products-count:"+count);
            }catch (Exception e){
                LOGGER.error("YibaiProductController.selectProductPage: "  + e);
            }
        }

        return SUCCESS;
    }

}
