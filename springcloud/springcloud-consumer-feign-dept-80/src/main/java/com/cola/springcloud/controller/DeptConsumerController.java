package com.cola.springcloud.controller;

import com.cola.springcloud.pojo.Dept;
import com.cola.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService service = null;

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept) {
        return this.service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept findById(@PathVariable("id") Long id) {
        return this.service.findById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> findAll() {
        return this.service.findAll();
    }


}
