package com.example.task.Controller;

import com.example.task.Entity.TaskData;
import com.example.task.From.LoginForm;
import com.example.task.From.SignUpForm;
import com.example.task.From.TaskForm;
import com.example.task.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/signup")
    String getSignUp(){
        return "signup";
    }

    @PostMapping("/signup")
    String postSignUp(@ModelAttribute SignUpForm signUpForm){
        taskService.signUpDataInsert(signUpForm);
        return "redirect:/login";
    }

    @GetMapping("/main")
    String getMain(){
        return "/main";
    }

    @GetMapping("task/{id}")
    String getTask(@PathVariable int id, Model model){
        System.out.println("テスト");
        var taskData = taskService.findById(id);
        model.addAttribute("taskData",taskData);
        model.addAttribute("id",id);
        return "task";
    }

    @PostMapping("/task/{id}")
    String getTask(@ModelAttribute TaskForm taskForm,@PathVariable int id){
        System.out.println("post");
        var test = taskService.taskUpdate(taskForm,id);
        return "redirect:/main";
    }



}
