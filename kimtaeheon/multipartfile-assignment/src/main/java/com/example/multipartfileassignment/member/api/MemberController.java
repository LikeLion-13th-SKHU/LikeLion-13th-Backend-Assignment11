package com.example.multipartfileassignment.member.api;

import com.example.multipartfileassignment.member.api.dto.response.MemberResponseDto;
import com.example.multipartfileassignment.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> createMember(@RequestParam String name, @RequestParam String email,
                                                          @RequestParam(required = false)MultipartFile imageFile) {
        MemberResponseDto createdMember = memberService.createMember(name, email, imageFile);
        return ResponseEntity.ok(createdMember);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable Long memberId) {
        MemberResponseDto member = memberService.getMember(memberId);
        return ResponseEntity.ok(member);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long memberId,
                                                          @RequestParam String name,
                                                          @RequestParam String email,
                                                          @RequestParam(required = false) MultipartFile newImageFile) {
        MemberResponseDto updatedMember = memberService.updateMember(memberId, name, email, newImageFile);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
