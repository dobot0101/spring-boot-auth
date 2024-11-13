package com.dobot0101.springbootauth;

import com.dobot0101.springbootauth.domain.member.CreateMemberDto;
import com.dobot0101.springbootauth.domain.member.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

  private final MemberService memberService;

  public DataInitializer(MemberService memberService) {
    this.memberService = memberService;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Hello World!");
    memberService
        .createMember(new CreateMemberDto("test@test.com", "tester", "1234"));
  }
}
