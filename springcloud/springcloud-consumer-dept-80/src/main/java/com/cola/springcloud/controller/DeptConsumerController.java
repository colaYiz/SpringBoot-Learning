package com.cola.springcloud.controller;

import com.cola.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    /**
     * 消费者不应该有service，因此使用RestTemplate访问restful接口比较简单直接
     * (url, requestMap, ResponseBean.class)这三个参数分别代表
     * Rest请求地址，请求参数，Http响应转换 被 转换成的对象类型
     */
    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add",dept,boolean.class);
    }
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept findById(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> findAll(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",List.class);
    }

    @RequestMapping("/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery",Object.class);
    }

}
