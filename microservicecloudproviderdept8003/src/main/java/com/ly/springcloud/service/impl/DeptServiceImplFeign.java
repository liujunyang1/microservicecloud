package com.ly.springcloud.service.impl;

import com.ly.springcloud.dao.DeptDao;
import com.ly.springcloud.entity.Dept;
import com.ly.springcloud.service.DeptClientSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImplFeign implements DeptClientSrvice {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
