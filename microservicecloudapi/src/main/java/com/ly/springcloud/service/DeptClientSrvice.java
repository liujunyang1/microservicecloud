package com.ly.springcloud.service;

import com.ly.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(value = "microservicecloudproviderdept")
@FeignClient(value = "microservicecloudproviderdept",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientSrvice {


    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    public List<Dept> findAll();


}
