package com.kimminwoo.multpartfile_assignment.image.api.dto.response;

public record ImageResponseDto(
        Long id,
        String originalName,
        String savedFileName,
        String savedPath
) {}