package com.dobot0101.springbootauth.domain.member;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    Member createMember(@RequestBody @Validated CreateMemberDto dto) {
        return memberService.createMember(dto);
    }

    Member findMember(@RequestParam UUID id) {
        return memberService.findMember(id);
    }

    List<Member> findAllMembers() {
        return memberService.findAllMembers();
    }

    Member upateMember(@RequestBody @Validated UpdateMemberDto dto) {
        return memberService.updateMember(dto);
    }

    void deleteMember(@RequestBody UUID id) {
        memberService.deleteMember(id);
    }
}
