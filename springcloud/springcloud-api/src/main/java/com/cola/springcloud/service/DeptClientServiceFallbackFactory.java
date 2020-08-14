package com.cola.springcloud.service;

import com.cola.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//服务降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    @Override
    public DeptClientService create(Throwable throwable) {
        DeptClientService deptClientService = new DeptClientService() {
            @Override
            public Dept findById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("id=>"+id+"没有对应的信息，客户端提供了降级的信息，这个服务现在已经被关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
        return deptClientService;
    }
}
