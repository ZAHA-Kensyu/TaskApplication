package com.example.task.register.dao;

import com.example.task.Entity.UserData;
import com.example.task.register.form.RegisterForm;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public interface RegisterDao{
    int registerInsert(RegisterForm registerForm);

    UserData registerCheck(String userId);
}
