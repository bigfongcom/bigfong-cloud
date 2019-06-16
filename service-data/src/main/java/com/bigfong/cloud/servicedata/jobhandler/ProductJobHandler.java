package com.bigfong.cloud.servicedata.jobhandler;


import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import com.bigfong.cloud.servicedata.common.CloudConstants;
import com.bigfong.cloud.servicedata.common.DateUtils;
import com.bigfong.cloud.servicedata.entity.basic.SysConfig;
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

import java.util.Date;
import java.util.List;

/**
 * 定时推送产品信息
 */
@JobHandler(value = "productJobHandler")
@Component
public class ProductJobHandler extends IJobHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductJobHandler.class);

    private static final Integer PAGE_SIZE = 2000;

    @Autowired
    private IProductService productService;

    @Autowired
    private ISysConfigService sysConfigService;

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        LOGGER.info(">>>>>>>>>>> productJobHandler-execute");

        if (StringUtils.isNotEmpty(param)){
            boolean flag = false;
            //判断是否在指定星期内,xxl-job cron   0 0/10 9-19 0 0 1/5 *报不合法
            Date today = new Date();
            Integer dayNum = DateUtils.getWeekOfDate(today);
            String[] params = param.split(",");
            for (String s : params) {
                if(dayNum == Integer.parseInt(s)){
                    flag = true;
                }
            }

            if (!flag){
                return SUCCESS;
            }

            SysConfig cfgCount = sysConfigService.getInfoByKeyName(CloudConstants.SYSCONFIG_PRODUCT_COUNT);
            SysConfig cfgPage = sysConfigService.getInfoByKeyName(CloudConstants.SYSCONFIG_PRODUCT_PAGE);
            if (cfgCount!=null && cfgPage!=null){
                int count = Integer.parseInt(cfgCount.getValue());
                int pageNumber = Integer.parseInt(cfgPage.getValue());

                try {
                    List<YibaiProduct> products = productService.getProductList(pageNumber,PAGE_SIZE);
                    LOGGER.info(">>>>>>>>>>> productJobHandler-products:"+products.size()+",page:"+pageNumber);

                    if (Math.ceil(count/PAGE_SIZE)>pageNumber){
                        //还会有下一页
                        if (products.size()==PAGE_SIZE){
                            pageNumber++;
                        }else{
                            //重新获取总记录数
                        /*count = productService.getProductCount();
                        if (count>0){
                            sysConfigService.updateInfo(CloudConstants.SYSCONFIG_PRODUCT_COUNT,count+"");
                        }*/
                            pageNumber=1;
                        }
                    }else if (Math.ceil(count/PAGE_SIZE)==pageNumber){
                        pageNumber=1;
                    }

                    sysConfigService.updateInfo(CloudConstants.SYSCONFIG_PRODUCT_PAGE,pageNumber+"");

                }catch (Exception e){
                    LOGGER.error("YibaiProductController.selectProductPage: "  + e);
                }
            }
        }




        return SUCCESS;
    }

}
