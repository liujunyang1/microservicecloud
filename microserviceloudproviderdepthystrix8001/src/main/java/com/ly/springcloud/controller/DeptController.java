package com.ly.springcloud.controller;

import com.ly.springcloud.entity.Dept;
import com.ly.springcloud.service.DeptClientSrvice;
import com.ly.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;
    @Autowired
    private DeptClientSrvice deptClientSrvice;

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public List<Dept> findAll(){
        return deptClientSrvice.findAll();
    }



    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix")
    public Dept get(@PathVariable("id") Integer id){
        Dept dept = this.service.findById(id);
        if (null == dept){
            throw new RuntimeException("该ID" + id + "没有对应的信息");
        }
        return dept;
    }


    public Dept processHystrix(@PathVariable("id") Integer id){
        Dept dept = new Dept();
        dept.setDname("zhang");
        return dept;
    }

}
