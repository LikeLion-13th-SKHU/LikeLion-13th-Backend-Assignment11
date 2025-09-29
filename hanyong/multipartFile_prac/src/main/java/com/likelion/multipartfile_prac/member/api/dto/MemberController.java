package com.likelion.multipartfile_prac.member.api.dto;

import com.likelion.multipartfile_prac.member.api.dto.response.MemberResDto;
import com.likelion.multipartfile_prac.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    //멤버 생성(이미지 포함)
    @PostMapping
    public ResponseEntity<MemberResDto> createMemer(@RequestParam String name,
                                                    @RequestParam String email,
                                                    @RequestParam(required = false) MultipartFile imageFile){
        MemberResDto createdMember = memberService.createMember(name, email, imageFile);
        return ResponseEntity.ok(createdMember);
    }

    //멤버 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResDto> getMember(@PathVariable Long memberId){
        MemberResDto member = memberService.getMember(memberId);
        return ResponseEntity.ok(member);
    }
    //멤버 수정(이미지 포함)
    @PutMapping("/{memberId}")
    public ResponseEntity<MemberResDto> updateMember(@PathVariable Long memberId,
                                                     @RequestParam String name,
                                                     @RequestParam String email,
                                                     @RequestParam(required = false) MultipartFile newImageFile){
        MemberResDto updateMember = memberService.updateMember(memberId, name, email, newImageFile);
        return ResponseEntity.ok(updateMember);
    }
    //멤버 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
