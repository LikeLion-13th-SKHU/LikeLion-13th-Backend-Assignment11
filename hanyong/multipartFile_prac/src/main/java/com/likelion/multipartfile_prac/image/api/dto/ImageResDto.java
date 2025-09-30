package com.likelion.multipartfile_prac.image.api.dto;

public record ImageResDto(
        Long id,
        String originalName,
        String savedFileName,
        String savedPath
) {
}
