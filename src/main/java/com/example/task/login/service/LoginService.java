package com.example.task.login.service;

import com.example.task.login.entity.LoginEntity;
import com.example.task.login.form.LoginForm;

import java.util.List;

public interface LoginService {
    List<LoginEntity> loginCheck(LoginForm loginForm);
}
