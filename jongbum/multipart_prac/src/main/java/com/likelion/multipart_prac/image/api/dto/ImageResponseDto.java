package com.likelion.multipart_prac.image.api.dto;

public record ImageResponseDto(
        Long id,
        String originalName,
        String savedFileName,
        String savedPath
) {}