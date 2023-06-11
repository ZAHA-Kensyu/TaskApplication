package com.example.task.register.dao;

import com.example.task.Entity.UserData;
import com.example.task.register.form.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDaoImpl implements  RegisterDao{
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public int registerInsert(RegisterForm registerForm){
        var param = new MapSqlParameterSource();
        param.addValue("userId",registerForm.getUserId());
        param.addValue("password",registerForm.getPassword());
        param.addValue("email",registerForm.getEmail());
        String sql = "INSERT INTO users(user_id,password,email) VALUES(:userId,:password,:email)";
        return namedParameterJdbcTemplate.update(sql,param);
    }

    public UserData registerCheck(String userId){
        var param = new MapSqlParameterSource();
        param.addValue("userId",userId);
        String sql = "SELECT * FROM users WHERE user_id = :userId";
        var list = namedParameterJdbcTemplate.query(sql,param,new DataClassRowMapper<>(UserData.class));
        return list.isEmpty() ? null : list.get(0);
    }
}
