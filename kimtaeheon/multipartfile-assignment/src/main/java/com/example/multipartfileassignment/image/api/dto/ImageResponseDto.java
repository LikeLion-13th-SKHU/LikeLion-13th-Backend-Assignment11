package com.example.multipartfileassignment.image.api.dto;

public record ImageResponseDto(
        Long id,
        String originalName,
        String savedFileName,
        String savedPath
) {}
