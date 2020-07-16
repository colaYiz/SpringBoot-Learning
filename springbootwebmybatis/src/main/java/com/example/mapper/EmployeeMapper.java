package com.example.mapper;

import com.example.dto.EmployeeDTO;
import com.example.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    //查询全部员工信息
    List<EmployeeDTO> selectAllEmployeeDTO();
    //根据id查询员工信息
    Employee selectEmployeeById(int id);
    //添加员工信息
    int addEmployee(Employee employee);
    //根据修改员工信息
    int updateEmployee(Employee employee);
    //根据id删除员工
    int delEmployee(int id);
}
