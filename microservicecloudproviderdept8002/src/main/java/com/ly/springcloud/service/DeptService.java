package com.ly.springcloud.service;

import com.ly.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept findById(Long deptno);

    public List<Dept> findAll();


}
