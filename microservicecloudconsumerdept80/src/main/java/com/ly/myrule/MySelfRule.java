package com.ly.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    public IRule myRule(){
        return new RandomRule();//自定义自己的轮循算法
    }

}
