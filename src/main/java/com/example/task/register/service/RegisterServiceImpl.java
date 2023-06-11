package com.example.task.register.service;

import com.example.task.Entity.UserData;
import com.example.task.register.dao.RegisterDao;
import com.example.task.register.form.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements  RegisterService {
    @Autowired
    RegisterDao registerDao;
    public int registerInsert(RegisterForm registerForm){return registerDao.registerInsert(registerForm);}

    public UserData registerCheck(String userId){return registerDao.registerCheck(userId);}
}
