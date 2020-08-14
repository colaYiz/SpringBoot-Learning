package com.cola.springcloud.mapper;

import com.cola.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    public boolean addDept(Dept dept);  //添加一个部门
    public Dept findById(Long id);  //根据id查询部门
    public List<Dept> findAll();    //查询所有部门
}
