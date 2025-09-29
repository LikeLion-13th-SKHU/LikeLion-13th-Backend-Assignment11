package com.likelion.multipartfile_prac.member.api.dto.response;

import com.likelion.multipartfile_prac.image.api.dto.ImageResDto;

public record MemberResDto(
        Long id,
        String email,
        String name,
        ImageResDto image
) {
}
