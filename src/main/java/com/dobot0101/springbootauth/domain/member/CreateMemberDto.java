package com.dobot0101.springbootauth.domain.member;

import lombok.Getter;

@Getter
public class CreateMemberDto {
    private String email;
    private String name;
    private String password;
}
