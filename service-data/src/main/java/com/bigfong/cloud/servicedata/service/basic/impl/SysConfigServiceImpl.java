package com.bigfong.cloud.servicedata.service.basic.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.servicedata.entity.basic.SysConfig;
import com.bigfong.cloud.servicedata.mapper.SysConfigMapper;
import com.bigfong.cloud.servicedata.service.basic.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Override
    public SysConfig getInfoByKeyName(String key) {
        return sysConfigMapper.getInfoByKey(key);
    }

    @Override
    public Integer updateInfo(String key, String value) {
        return sysConfigMapper.updateInfo(key,value);
    }
}
