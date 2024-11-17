package com.dobot0101.springbootauth.domain.member;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping
  public MemberResponseDto createMember(@RequestBody @Valid CreateMemberDto dto) {
    return memberService.createMember(dto);
  }

  @GetMapping("{id}")
  public MemberResponseDto findMember(@PathVariable UUID id) {
    return memberService.findMember(id);
  }

  @GetMapping
  public List<MemberResponseDto> findAllMembers() {
    return memberService.findAllMembers();
  }

  @PatchMapping("{id}")
  public MemberResponseDto upateMember(@PathVariable UUID id, @RequestBody @Valid UpdateMemberDto dto) {
    return memberService.updateMember(id, dto);
  }

  @DeleteMapping("{id}")
  public void deleteMember(@PathVariable UUID id) {
    memberService.deleteMember(id);
  }
}
