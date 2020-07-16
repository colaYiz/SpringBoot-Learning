package com.example.controller;


import com.example.dto.EmployeeDTO;
import com.example.pojo.Department;
import com.example.pojo.Employee;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    //查询所有员工列表
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<EmployeeDTO> employees = employeeService.selectAllEmployeeDTO();
        model.addAttribute("emps",employees);
        return "emp/list.html";
    }

    //to员工添加页面
    @GetMapping("/emp")
    public String toAddpage(Model model){
        //查出部门的信息
        Collection<Department> departments = departmentService.selectAllDepartment();
        model.addAttribute("departments",departments);
        return "emp/add.html";
    }

    //添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加操作
        System.out.println("add->" + employee);
        employeeService.addEmployee(employee);
        return "redirect:/emps";
    }

    //to员工信息修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        //查出原来的数据
        Employee employee = employeeService.selectEmployeeById(id);
        System.out.println(employee);
        model.addAttribute("emp",employee);
        //查出部门的信息
        Collection<Department> departments = departmentService.selectAllDepartment();
        System.out.println(departments);
        model.addAttribute("departments",departments);
        return "emp/update.html";
    }

    //员工信息修改
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/emps";
    }

    //员工删除页面
    @GetMapping("/delemp/{id}")
    public String toDeleteEmp(@PathVariable("id")Integer id){
        employeeService.delEmployee(id);
        return "redirect:/emps";
    }


}
