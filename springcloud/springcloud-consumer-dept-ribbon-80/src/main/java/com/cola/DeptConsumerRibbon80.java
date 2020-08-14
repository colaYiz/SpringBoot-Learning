package com.cola;

import com.cola.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient	//启用Eureka服务注册与发现
@SpringBootApplication
//在微服务启动的时候就能去加载我们自定义Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)
public class DeptConsumerRibbon80 {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerRibbon80.class, args);
	}

}
