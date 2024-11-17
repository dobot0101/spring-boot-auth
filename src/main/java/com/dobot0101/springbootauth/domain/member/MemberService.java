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

  public MemberResponseDto createMember(CreateMemberDto dto) {
    // 중복 회원 확인
    Optional<Member> memberOpt = memberRepository.findByEmail(dto.getEmail());
    if (memberOpt.isPresent()) {
      throw new RuntimeException("이미 존재하는 이메일 입니다. " + dto.getEmail());
    }

    var encryptedPassword = passwordEncoder.encode(dto.getPassword());
    var member = memberRepository.save(
        new Member(UUID.randomUUID(), dto.getEmail(), dto.getName(), encryptedPassword));
    return new MemberResponseDto(member.getId(), member.getEmail(), member.getName());
  }

  public MemberResponseDto findMember(UUID id) {
    var member = memberRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("member not found: " + id));
    return new MemberResponseDto(member.getId(), member.getEmail(), member.getName());
  }

  public List<MemberResponseDto> findAllMembers() {
    List<Member> members = memberRepository.findAll();
    return members.stream()
        .map(member -> new MemberResponseDto(member.getId(), member.getEmail(), member.getName()))
        .toList();
  }

  public MemberResponseDto updateMember(UUID id, UpdateMemberDto dto) {
    var member = memberRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("member not found: " + id));
    if (dto.getName() != null) {
      member.setName(dto.getName());
    }
    memberRepository.save(member);
    return new MemberResponseDto(member.getId(), member.getEmail(), member.getName());
  }

  public void deleteMember(UUID id) {
    memberRepository.deleteById(id);
  }
}
