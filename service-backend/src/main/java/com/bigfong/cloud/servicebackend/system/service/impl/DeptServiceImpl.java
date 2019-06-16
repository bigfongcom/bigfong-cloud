package com.bigfong.cloud.servicebackend.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigfong.cloud.servicebackend.common.dto.Tree;
import com.bigfong.cloud.servicebackend.common.utils.TreeUtils;
import com.bigfong.cloud.servicebackend.system.entity.Dept;
import com.bigfong.cloud.servicebackend.system.mapper.DeptMapper;
import com.bigfong.cloud.servicebackend.system.service.DeptService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper,Dept> implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Tree<Dept>> tree() {
        List<Dept> list = queryList(new Dept());
        List<Tree<Dept>> treeList = new ArrayList<>();
        list.forEach(dept -> {
            Tree<Dept> tree = new Tree<>();
            tree.setId(dept.getId());
            tree.setParentId(dept.getParentId());
            tree.setName(dept.getName());
            treeList.add(tree);
        });
        return TreeUtils.build(treeList);
    }

    @Override
    public List<Dept> queryList(Dept dept) {
        try {
           QueryWrapper<Dept> wrapper = new QueryWrapper<>();
            if (StringUtils.isNotBlank(dept.getName())) {
                wrapper.eq("name", dept.getName());
            }
            return deptMapper.selectList(wrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Dept findById(Integer id) {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return deptMapper.selectOne(wrapper);
    }

    @Override
    @Transactional
    public void add(Dept dept) {
        Integer pid = dept.getParentId();
        if (pid == null) {
            dept.setParentId(0);
        }
        dept.setCreateTime(new Date());
        deptMapper.insert(dept);
    }

    @Override
    public boolean checkName(String name, String id) {
        if (name.isEmpty()) {
            return false;
        }
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.eq("lower(name)", name.toLowerCase());
        if (!id.isEmpty()) {
            wrapper.ne("id", id);
        }

        List<Dept> depts = deptMapper.selectList(wrapper);
        if (depts.size() > 0) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public void update(Dept dept) {
        QueryWrapper<Dept> wrapper = new QueryWrapper<>();
        wrapper.ne("id", dept.getId());
        deptMapper.update(dept,wrapper);
    }

    @Override
    @Transactional
    public void delete(List<Integer> ids) {
        deptMapper.deleteBatchIds(ids);
        this.deptMapper.changeTopNode(ids);
    }


}
