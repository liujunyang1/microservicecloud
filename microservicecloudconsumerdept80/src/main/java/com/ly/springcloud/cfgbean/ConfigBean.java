package com.ly.springcloud.cfgbean;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //RestTemplate提供了多种便捷访问远程Http服务的方法
    //是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问的Rest服务的客户端模板工具集

    @Bean
    @LoadBalanced  //负载均衡的配置
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }

    /**
     * 达到的目的，用我们重新选择的随机算法替代默认的轮循
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();//随机算法
    }
}
