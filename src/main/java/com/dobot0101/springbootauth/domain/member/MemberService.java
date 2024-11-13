package com.dobot0101.springbootauth.domain.member;

import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
  final MemberRepository memberRepository;

  public Member createMember(CreateMemberDto dto) {
    return memberRepository.save(
        new Member(UUID.randomUUID(), dto.getEmail(), dto.getName(), dto.getPassword()));
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
