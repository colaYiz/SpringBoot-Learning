package com.cola.springcloud.service;

import com.cola.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept dept);  //添加一个部门
    public Dept findById(Long id);  //根据id查询 部门
    public List<Dept> findAll();    //查询所有部门
}
