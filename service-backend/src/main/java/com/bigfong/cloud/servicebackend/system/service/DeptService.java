package com.bigfong.cloud.servicebackend.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bigfong.cloud.servicebackend.common.dto.Tree;
import com.bigfong.cloud.servicebackend.system.entity.Dept;

import java.util.List;

public interface DeptService extends IService<Dept> {

    List<Tree<Dept>> tree();

    List<Dept> queryList(Dept dept);

    Dept findById(Integer id);

    void add(Dept dept);

    boolean checkName(String name, String id);

    void update(Dept dept);

    void delete(List<Integer> ids);
}
