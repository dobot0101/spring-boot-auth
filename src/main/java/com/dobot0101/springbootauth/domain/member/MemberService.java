package com.dobot0101.springbootauth.domain.member;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  public Member createMember(CreateMemberDto dto) {
    // 중복 회원 확인
    Optional<Member> memberOpt = memberRepository.findByEmail(dto.getEmail());
    if (memberOpt.isPresent()) {
      throw new RuntimeException("이미 존재하는 이메일 입니다. " + dto.getEmail());
    }

    var encryptedPassword = passwordEncoder.encode(dto.getPassword());

    return memberRepository.save(
        new Member(UUID.randomUUID(), dto.getEmail(), dto.getName(), encryptedPassword));
  }

  public Member findMember(UUID id) {
    return memberRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("member not found: " + id));
  }

  public List<Member> findAllMembers() {
    return memberRepository.findAll();
  }

  public Member updateMember(UUID id, UpdateMemberDto dto) {
    Member member = this.findMember(id);
    if (dto.getName() != null) {
      member.setName(dto.getName());
    }
    memberRepository.save(member);
    return member;
  }

  public void deleteMember(UUID id) {
    memberRepository.deleteById(id);
  }
}
