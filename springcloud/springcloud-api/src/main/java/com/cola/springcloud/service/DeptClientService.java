package com.cola.springcloud.service;

import com.cola.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "springcloud-provider-dept", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    public Dept findById(@PathVariable("id")Long id);

    @GetMapping("/dept/list")
    public List<Dept> findAll();

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept);
}
