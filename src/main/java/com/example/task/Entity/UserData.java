package com.example.task.Entity;

import lombok.Data;

@Data
public class UserData {
    Integer id;
    String userId;
    String password;
    Integer permission;
    String email;
}
