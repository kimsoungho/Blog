package com.sparta.blog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PasswordDto {

    public int password;

    public PasswordDto(int password) {
        this.password = password;
    }
}