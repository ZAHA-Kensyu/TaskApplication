package com.example.task.login.dao;

import com.example.task.login.entity.LoginEntity;
import com.example.task.login.form.LoginForm;

import java.util.List;

public interface LoginDao {
    List<LoginEntity> loginCheck(LoginForm loginForm);
}
