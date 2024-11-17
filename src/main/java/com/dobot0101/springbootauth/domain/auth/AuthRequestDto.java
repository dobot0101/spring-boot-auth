package com.dobot0101.springbootauth.domain.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AuthRequestDto {

  @NotBlank(message = "이메일을 입력해 주세요.")
  @Email(message = "이메일 형식으로 입력해 주세요.")
  private String email;

  @NotBlank(message = "암호를 입력해 주세요.")
  @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
  private String password;
}
