package com.likelion.multipart_prac.member.domain.repository;

import com.likelion.multipart_prac.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}