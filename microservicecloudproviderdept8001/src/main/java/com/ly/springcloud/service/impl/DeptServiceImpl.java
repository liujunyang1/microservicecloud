package com.ly.springcloud.service.impl;

import com.ly.springcloud.dao.DeptDao;
import com.ly.springcloud.entity.Dept;
import com.ly.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept findById(Long deptno) {
        return deptDao.findById(deptno);
    }

    @Override
    public List<Dept> findAll() {
        System.out.println("8001测试轮循-------------------{}");
        return deptDao.findAll();
    }
}
