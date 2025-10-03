package com.likelion.multipart_prac.member.api.dto.response;

import com.likelion.multipart_prac.image.api.dto.ImageResponseDto;

public record MemberResponseDto(
        Long id,
        String email,
        String name,
        ImageResponseDto image
) {}
