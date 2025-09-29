package com.example.multipartfileassignment.member.api.dto.response;

import com.example.multipartfileassignment.image.api.dto.ImageResponseDto;

public record MemberResponseDto(
        Long id,
        String email,
        String name,
        ImageResponseDto image
) {}
