package com.likelion.multipartfile_assignment.member.api.dto.response;

import com.likelion.multipartfile_assignment.image.api.dto.ImageResponseDto;

public record MemberResponseDto(
        Long id,
        String email,
        String name,
        ImageResponseDto image
) {}
