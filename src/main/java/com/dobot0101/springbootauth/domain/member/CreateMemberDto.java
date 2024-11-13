package com.dobot0101.springbootauth.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateMemberDto {

  private String email;
  private String name;
  private String password;
}
