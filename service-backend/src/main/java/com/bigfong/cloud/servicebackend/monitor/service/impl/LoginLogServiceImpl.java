package com.bigfong.cloud.servicebackend.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.servicebackend.monitor.entity.LoginLog;
import com.bigfong.cloud.servicebackend.monitor.mapper.LoginLogMapper;
import com.bigfong.cloud.servicebackend.monitor.service.LoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;


@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {

    @Autowired
    private LoginLogMapper mapper;

    @Override
    public List<LoginLog> findByPage(LoginLog log) {
        try {
            QueryWrapper<LoginLog> wrapper = new QueryWrapper<>();

            if (StringUtils.isNotBlank(log.getLocation())) {
                wrapper.eq("location", log.getLocation());
            }
            if (StringUtils.isNotBlank(log.getFiledTime())) {
                String[] split = log.getFiledTime().split(",");
                wrapper.ge("data_format(CREATE_TIME, '%Y-%m-%d')", split[0]);
                wrapper.le("data_format(CREATE_TIME, '%Y-%m-%d')", split[1]);
            }
            wrapper.orderByDesc("create_time");
            return mapper.selectList(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    //@Transactional
    public void delete(@RequestBody List<Long> ids) {
        try {
            mapper.deleteBatchIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    //@Transactional
    public void saveLog(LoginLog log) {
        try {
            this.save(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
