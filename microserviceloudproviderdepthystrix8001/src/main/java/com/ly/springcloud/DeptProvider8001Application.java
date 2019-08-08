package com.ly.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient//做服务发现
@EnableEurekaClient//本服务启动后会自动注册进eureka服务中
@MapperScan("com.ly.springcloud.dao")
@SpringBootApplication
@EnableCircuitBreaker//对Hystrix熔断机制的支持
public class DeptProvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001Application.class,args);
    }

}
