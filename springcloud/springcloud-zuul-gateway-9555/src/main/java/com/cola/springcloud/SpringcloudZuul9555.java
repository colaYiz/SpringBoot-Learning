package com.cola.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringcloudZuul9555 {

    public static void main(String[] args){
        SpringApplication.run(SpringcloudZuul9555.class,args);
    }
}
