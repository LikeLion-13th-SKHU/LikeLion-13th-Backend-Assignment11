package com.likelion.multipartfile_prac.member.domain;


import com.likelion.multipartfile_prac.image.domain.Image;
import jakarta.persistence.*;
import lombok.*;



@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Image image;

    @Builder
    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void updateImage(Image image){
        if(this.image != null){
            this.image.updateMember(null);
        }
        this.image = image;
        if(image != null && image.getMember() != null){
            image.updateMember(this);
        }
    }

    public void update(String name, String email){
        this.name = name;
        this.email = email;
    }

}
