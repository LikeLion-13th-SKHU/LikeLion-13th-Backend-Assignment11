package com.likelion.multipartfile_assignment.image.api.dto;

public record ImageResponseDto(
        Long id,
        String originalName,
        String savedFileName,
        String savedPath
) {}