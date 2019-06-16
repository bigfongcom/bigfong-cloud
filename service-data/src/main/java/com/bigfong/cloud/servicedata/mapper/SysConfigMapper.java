package com.bigfong.cloud.servicedata.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigfong.cloud.servicedata.entity.basic.SysConfig;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * 产品表
 * Mapper 接口
 * </p>
 */
public interface SysConfigMapper extends BaseMapper<SysConfig> {

    SysConfig getInfoByKey(@Param("key") String key);

    Integer updateInfo(@Param("key") String key, @Param("value") String value);
}
