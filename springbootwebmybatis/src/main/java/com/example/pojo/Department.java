package com.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    private int id;
    private String departmentName;
}
