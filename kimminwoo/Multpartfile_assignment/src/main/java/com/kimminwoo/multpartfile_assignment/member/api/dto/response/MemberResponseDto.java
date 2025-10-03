package com.kimminwoo.multpartfile_assignment.member.api.dto.response;

import com.kimminwoo.multpartfile_assignment.image.api.dto.response.ImageResponseDto;

public record MemberResponseDto(
        Long id,
        String email,
        String name,
        ImageResponseDto image
) {}
