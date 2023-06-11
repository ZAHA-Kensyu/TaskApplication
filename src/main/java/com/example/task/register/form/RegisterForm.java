package com.example.task.register.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterForm {
    @NotEmpty(message = "ユーザーIdは必須です。")
    String userId;

    @NotEmpty(message = "パスワードは必須です。")
    String password;

    @NotEmpty(message = "メールアドレスは必須です。")
    @Email
    String email;
}
