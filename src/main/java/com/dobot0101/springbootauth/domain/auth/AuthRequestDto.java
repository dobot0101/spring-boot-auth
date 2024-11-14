package com.dobot0101.springbootauth.domain.auth;

import lombok.Data;

@Data
public class AuthRequestDto {
  private String email;
  private String password;
}
