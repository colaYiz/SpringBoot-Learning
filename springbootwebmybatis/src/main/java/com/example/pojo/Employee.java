package com.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//员工表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String employeeName;
    private String email;
    private int gender; //0:女  1:男
    private int departmentId;
    private Date date;

    public Employee(Integer id, String employeeName, String email, int gender, int departmentId) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.gender = gender;
        this.departmentId = departmentId;
        //默认的创建日期
        this.date = new Date();
    }
}
