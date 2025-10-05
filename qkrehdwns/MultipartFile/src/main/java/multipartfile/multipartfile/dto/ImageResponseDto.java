package multipartfile.multipartfile.dto;

public record ImageResponseDto(
    Long id,
    String originalName,
    String savedFileName,
    String savedPath
) {}
