package com.bigfong.cloud.servicedata.service.basic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.cloudcommon.product.YibaiProduct;
import com.bigfong.cloud.servicedata.entity.basic.SysConfig;
import com.bigfong.cloud.servicedata.entity.product.YibaiProductMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 产品表
 服务类
 * </p>

 */
public interface ISysConfigService extends IService<SysConfig> {

    SysConfig getInfoByKeyName(String key);

    Integer updateInfo(String key,String value);
}