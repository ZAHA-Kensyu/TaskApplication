package com.example.task.register.service;

import com.example.task.Entity.UserData;
import com.example.task.register.form.RegisterForm;

public interface RegisterService {
    int registerInsert(RegisterForm registerForm);

    UserData registerCheck(String userId);
}
