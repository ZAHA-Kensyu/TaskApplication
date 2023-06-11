package com.example.task.login.controller;

import com.example.task.login.form.LoginForm;
import com.example.task.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired LoginService loginService;

    @GetMapping("/login")
    String getLogin(@ModelAttribute LoginForm loginForm){
        return "/login";
    }

    @PostMapping("/login")
    String postLogin(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult, Model model){
        var loginData = loginService.loginCheck(loginForm);
        if(loginData.isEmpty()){
            model.addAttribute("loginError","ユーザーIDまたはパスワードが間違えています。");
        }
        if(bindingResult.hasErrors() || loginData.isEmpty()){
            return "/login";
        }else{
            return "redirect:/main";
        }
    }
}
