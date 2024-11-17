package com.dobot0101.springbootauth.domain.member;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberResponseDto {

  private UUID id;
  private String email;
  private String name;
}
