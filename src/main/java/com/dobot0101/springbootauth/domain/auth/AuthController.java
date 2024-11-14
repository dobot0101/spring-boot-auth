package com.dobot0101.springbootauth.domain.auth;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;

  @PostMapping
  public AuthResponseDto login(@RequestBody AuthRequestDto dto) {
    String token = authService.authenticate(dto);
    return new AuthResponseDto(token);
  }
}
