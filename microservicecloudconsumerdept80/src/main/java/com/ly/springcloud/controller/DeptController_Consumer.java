package com.ly.springcloud.controller;

import com.ly.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://microservicecloudproviderdept";



    /**
     * 使用restTemplate访问restful接口非常的简单粗暴无脑
     * (url,requestMap,ResponseBean.class)这三个参数分别代表
     * REST请求地址、请求参数、HTTP响应转换被转换成的对象类型
     */
    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("consumer/dept/add")
    public boolean add(Dept dept){
        return  restTemplate.postForObject(REST_URL_PREFIX+"/addDept",dept,Boolean.class);
    }

    @GetMapping("consumer/dept/get/{id}")
    public Dept findById(@PathVariable("id") Long id){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/deptno/"+id,Dept.class);
    }

    @GetMapping("consumer/dept/getAll")
    public List<Dept> findAll(){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/findAll",List.class);
    }



    //消费者可以调用服务发现      仅是了解
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }


}
