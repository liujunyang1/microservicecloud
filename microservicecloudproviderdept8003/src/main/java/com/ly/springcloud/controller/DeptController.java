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





//    @Bean
//    public IRule myRule(){
//        //return new RandomRule();//随机选取一个服务，进行访问
//        //return new RoundRobinRule();//轮询方式选取一个服务，进行访问
//        //return  new RetryRule();//如果一个服务挂了，会尝试几次访问，如果几次访问失败后，下次就跳过失败的服务。
//        //return new WeightedResponseTimeRule();//按照权重访问
//        //return new PredicateBasedRule();//先过滤清单再轮训
//        return new BestAvailableRule(); //当高并发时，会选中最空闲当服务
//    }
}
