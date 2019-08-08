package com.ly.springcloud.service;

import com.ly.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientSrvice> {


    @Override
    public DeptClientSrvice create(Throwable throwable) {
        return new DeptClientSrvice() {
            @Override
            public List<Dept> findAll() {
                Dept dept = new Dept();
                dept.setDname("张三的熔断设置------------{}");
                List list = new ArrayList();
                list.add(dept);
                return list;
            }
        };
    }
}
