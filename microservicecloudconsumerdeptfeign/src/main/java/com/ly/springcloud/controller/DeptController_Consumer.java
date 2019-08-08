package com.ly.springcloud.controller;

import com.ly.springcloud.entity.Dept;
import com.ly.springcloud.service.DeptClientSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientSrvice deptClientSrvice;


    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return this.deptClientSrvice.findAll();
    }


}
