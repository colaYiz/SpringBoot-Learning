package com.cola.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient     //本服务启动后会自动注册到Eureka中
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker   //对Hystrix服务熔断机制的支持
public class DeptProviderHystrix8001 {

    @Bean
    public ServletRegistrationBean  hystrixMetricsStreamServlet(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registration.addUrlMappings("/actuator/hystrix.stream");
        return registration;
    }

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrix8001.class,args);
    }

}