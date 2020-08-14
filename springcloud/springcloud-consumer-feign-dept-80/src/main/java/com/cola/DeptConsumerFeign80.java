package com.cola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan("com.cola.springcloud")
public class DeptConsumerFeign80 {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerFeign80.class, args);
	}

}
