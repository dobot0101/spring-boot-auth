package com.dobot0101.springbootauth.domain.auth;

import com.dobot0101.springbootauth.JwtUtil;
import com.dobot0101.springbootauth.domain.member.Member;
import com.dobot0101.springbootauth.domain.member.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtUtil jwtUtil;

  public String authenticate(AuthRequestDto dto) {
    Optional<Member> memberOpt = memberRepository.findByEmail(dto.getEmail());
    if (memberOpt.isEmpty()) {
      throw new RuntimeException("이메일 또는 암호가 잘못되었습니다.");
    }

    Member member = memberOpt.get();
    if (member.getPassword().equals(passwordEncoder.encode(dto.getPassword()))) {
      throw new RuntimeException("이메일 또는 암호가 잘못되었습니다.");
    }
    return jwtUtil.generateToken(dto.getEmail());
  }
}
