package com.ly.springcloud.dao;

import com.ly.springcloud.entity.Dept;

import java.util.List;

public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long deptno);

    public List<Dept> findAll();
}
