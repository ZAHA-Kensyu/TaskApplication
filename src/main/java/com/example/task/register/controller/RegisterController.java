package com.example.task.register.controller;

import com.example.task.register.form.RegisterForm;
import com.example.task.register.service.RegisterService;
import com.example.task.register.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @GetMapping("/register")
    String getRegister(){
        return "/register";
    }

    @PostMapping("/register")
    String postRegister(@Validated @ModelAttribute RegisterForm registerForm, BindingResult bindingResult, Model model){
        var usersList = registerService.registerCheck(registerForm.getUserId());
        if(usersList != null){
            System.out.println("Idが被っています。");
            model.addAttribute("userIdError","ユーザーIDが登録されています。");
            return "/register";
        }

        if(bindingResult.hasErrors()){
            //エラーが出た時。
            System.out.println("エラー");
            return "/register";
        }else{
            System.out.println("成功");
            registerService.registerInsert(registerForm);
            return "redirect:/login";
        }
    }
}
