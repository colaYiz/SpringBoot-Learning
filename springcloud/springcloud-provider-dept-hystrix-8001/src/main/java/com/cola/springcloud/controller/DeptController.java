package com.cola.springcloud.controller;

import com.cola.springcloud.pojo.Dept;
import com.cola.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    //获取一些配置信息，得到具体的微服务
//    @Autowired
//    private DiscoveryClient discoveryClient;

    //一旦调用服务方法失败并抛出了错误信息后
    // 会自动调用HystrixCommand标注好的fallbackMethod调用类中指定方法
    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = deptService.findById(id);
        if(dept == null){
            throw new RuntimeException("id=>"+id+"不存在该用户，查找失败");
        }
        return dept;
    }

    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>"+id+"没有对应的信息，null--@Hystrix")
                .setDb_source("no this database in MySQL");
    }

//
//    @GetMapping("/dept/discovery")
//    public Object discovery(){
//        //获取微服务清单列表
//        List<String> services = discoveryClient.getServices();
//        System.out.println("discoveryClient.getServices:" + services);
//        //得到具体的微服务
//        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-provider-dept");
//        for(ServiceInstance  serviceInstance : instances){
//            System.out.println(
//                    serviceInstance.getInstanceId()+"\t"+
//                    serviceInstance.getHost()+"\t"+
//                    serviceInstance.getPort()+"\t"+
//                    serviceInstance.getUri()
//            );
//        }
//        return this.discoveryClient;
//    }
//
//    //如果参数是放在请求中传入后台，需要用@RequestBody才能接收到
//    //添加一个部门
//    @PostMapping("/dept/add")
//    public boolean addDept(@RequestBody Dept dept){
//        return deptService.addDept(dept);
//    }
//
//    //根据id查询部门
//    @GetMapping("dept/get/{id}")
//    public Dept findById(@PathVariable("id") Long id){
//        Dept dept = deptService.findById(id);
//        if(dept==null){
//            throw new RuntimeException("Fail");
//        }
//        return dept;
//    }
//
//    //查询所有部门
//    @GetMapping("/dept/list")
//    public List<Dept> findAll(){
//        return deptService.findAll();
//    }

}
