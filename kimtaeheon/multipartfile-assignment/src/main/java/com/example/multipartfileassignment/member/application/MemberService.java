package com.example.multipartfileassignment.member.application;

import com.example.multipartfileassignment.image.api.dto.ImageResponseDto;
import com.example.multipartfileassignment.image.application.ImageService;
import com.example.multipartfileassignment.image.domain.Image;
import com.example.multipartfileassignment.member.api.dto.response.MemberResponseDto;
import com.example.multipartfileassignment.member.domain.Member;
import com.example.multipartfileassignment.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final ImageService imageService;

    @Transactional
    public MemberResponseDto createMember(String name, String eamil, MultipartFile imageFile) {
        Member member = Member.builder()
                .name(name)
                .email(eamil)
                .build();
        if (imageFile != null && !imageFile.isEmpty()) {
            Image image = imageService.saveImage(imageFile);

            member.updateImage(image);
            image.updateMember(member);
        }

        Member savedMember = memberRepository.save(member);

        Image savedImage = savedMember.getImage();
        ImageResponseDto imageResponseDto = null;
        if (savedImage != null) {
            imageResponseDto = new ImageResponseDto(
                    savedImage.getId(),
                    savedImage.getOriginalFileName(),
                    savedImage.getSavedFileName(),
                    savedImage.getSavedPath()
            );
        }
        return new MemberResponseDto(
                savedMember.getId(),
                savedMember.getEmail(),
                savedMember.getName(),
                imageResponseDto
        );
    }

    public MemberResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        Image image = member.getImage();
        ImageResponseDto imageResponseDto = null;
        if (image != null) {
            imageResponseDto = new ImageResponseDto(
                    image.getId(),
                    image.getOriginalFileName(),
                    image.getSavedFileName(),
                    image.getSavedPath()
            );
        }
        return new MemberResponseDto(
                member.getId(),
                member.getEmail(),
                member.getName(),
                imageResponseDto
        );
    }

    @Transactional
    public MemberResponseDto updateMember(Long memberId, String name, String email, MultipartFile newImageFile) {
        Member existingMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        existingMember.update(name, email);

        if (newImageFile != null && !newImageFile.isEmpty()) {
            Image oldImage = existingMember.getImage();

            if (oldImage != null) {
                try {
                    Path oldImagePath = Paths.get(oldImage.getSavedPath());
                    Files.deleteIfExists(oldImagePath);
                } catch (Exception e) {
                    System.err.println("기존 이미지 파일 삭제 중 오류 발생: " + e.getMessage());
                }
            }

            Image newImage = imageService.saveImage(newImageFile);
            newImage.updateMember(existingMember);
            existingMember.updateImage(newImage);
        }

        Member updatedMember = memberRepository.save(existingMember);

        Image updatedImage = updatedMember.getImage();
        ImageResponseDto imageResponseDto = null;
        if (updatedImage != null) {
            imageResponseDto = new ImageResponseDto(
                    updatedImage.getId(),
                    updatedImage.getOriginalFileName(),
                    updatedImage.getSavedFileName(),
                    updatedImage.getSavedPath()
            );
        }
        return new MemberResponseDto(
                updatedMember.getId(),
                updatedMember.getEmail(),
                updatedMember.getName(),
                imageResponseDto
        );
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        Image image = member.getImage();
        if (image != null) {
            try {
                String fullPath = image.getSavedPath();
                Path filePath = Paths.get(fullPath);

                System.out.println("삭제 시도 경로: " + fullPath);

                boolean isDeleted = Files.deleteIfExists(filePath);
                if (isDeleted) {
                    System.out.println("이미지 파일이 성공적으로 삭제되었습니다: " + fullPath);
                } else {
                    System.out.println("이미지 파일을 찾을 수 없습니다: " + fullPath);
                }
            } catch (Exception e) {
                System.err.println("이미지 파일 삭제 중 오류가 발생했습니다: " + e.getMessage());
            }
        }

        memberRepository.deleteById(memberId);
    }
}
