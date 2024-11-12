package com.dobot0101.springbootauth.domain.member;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MemberService {
    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(CreateMemberDto dto) {
        return memberRepository.save(new Member(UUID.randomUUID(), dto.getEmail(), dto.getName(), dto.getPassword()));
    }

    public Member findMember(UUID id) {
    }

    public List<Member> findAllMembers() {
    }

    public Member updateMember(UpdateMemberDto dto) {
    }

    public void deleteMember(UUID id) {
    }
}
