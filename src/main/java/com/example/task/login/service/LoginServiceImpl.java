package com.example.task.login.service;

import com.example.task.login.dao.LoginDao;
import com.example.task.login.entity.LoginEntity;
import com.example.task.login.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    LoginDao loginDao;
    public List<LoginEntity> loginCheck(LoginForm loginForm) {return loginDao.loginCheck(loginForm);}

}
