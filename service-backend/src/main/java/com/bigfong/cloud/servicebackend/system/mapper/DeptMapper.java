package com.bigfong.cloud.servicebackend.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bigfong.cloud.servicebackend.system.entity.Dept;

import java.util.List;

public interface DeptMapper extends BaseMapper<Dept> {

    void changeTopNode(List<Integer> ids);
}
