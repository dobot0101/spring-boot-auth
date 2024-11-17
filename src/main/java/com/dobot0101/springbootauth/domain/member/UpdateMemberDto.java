package com.dobot0101.springbootauth.domain.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;


@Getter
public class UpdateMemberDto {

  @NotBlank
  String name;
}
