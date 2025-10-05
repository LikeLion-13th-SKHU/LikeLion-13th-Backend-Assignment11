package multipartfile.multipartfile.dto;

public record MemberResponseDto(
    Long id,
    String email,
    String name,
    ImageResponseDto image
) {}
