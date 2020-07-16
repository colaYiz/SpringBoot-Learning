package com.example.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//管理员用户
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String usrName;
    private String password;
}
