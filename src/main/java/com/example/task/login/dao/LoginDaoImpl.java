package com.example.task.login.dao;

import com.example.task.login.entity.LoginEntity;
import com.example.task.login.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao{
    @Autowired
    private NamedParameterJdbcTemplate nameJdbcTemplate;

    public List<LoginEntity> loginCheck(LoginForm loginForm){
        var param = new MapSqlParameterSource();
        param.addValue("userId", loginForm.getUserId());
        param.addValue("password", loginForm.getPassword());
        String sql = "SELECT * FROM users WHERE user_id = :userId AND password = :password";
        return nameJdbcTemplate.query(sql,param,new DataClassRowMapper<>(LoginEntity.class));
    }
}
