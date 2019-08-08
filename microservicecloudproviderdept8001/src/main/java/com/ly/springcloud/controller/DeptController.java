package com.ly.springcloud.controller;

import com.ly.springcloud.entity.Dept;
import com.ly.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private DeptService deptService1;

    /**
     * 添加
     * @param dept
     * @return
     */
    @PostMapping("addDept")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("deptno/{id}")
    public Dept findById(@PathVariable("id") Long id){
        return deptService.findById(id);
    }

    @GetMapping("findAll")
    public List<Dept> findAll(){
        return  deptService1.findAll();
    }




    //服务的注册与发现     仅是了解
    @RequestMapping(value="/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("********"+list);
        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUDPROVIDERDEPT");
        for (ServiceInstance element : srvList){
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.client;

    }


}
