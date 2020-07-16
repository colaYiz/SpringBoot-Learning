package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session,Model model) {
        User user = userService.selectPasswordByName(username, password);
        if (user != null) {
            //登陆成功
            session.setAttribute("username",user.getUsrName());
            //防止表单重复提交，重定向
            return "redirect:/main.html";
        }else{
            //登陆失败
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }


}
