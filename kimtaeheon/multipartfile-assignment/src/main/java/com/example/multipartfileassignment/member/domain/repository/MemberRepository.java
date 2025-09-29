package com.example.multipartfileassignment.member.domain.repository;

import com.example.multipartfileassignment.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
