package com.example.task.login.entity;

import lombok.Data;

@Data
public class LoginEntity {
    Integer id;
    String userId;
    String password;
    Integer permission;
    String email;
}
