package com.cola.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;

//自定义Rule
public class MyRule {

//    @Bean
//    public IRule myRetryRule(){
//        return new RetryRule();
//    }

    @Bean
    public IRule myRandomRule(){
        return new MyRandomRule();
    }
}
