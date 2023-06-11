package com.example.task.login.form;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {
    @NotEmpty(message = "ユーザーIDは必須です。")
    String userId;

    @NotEmpty(message = "パスワードは必須です。")
    String password;
}
