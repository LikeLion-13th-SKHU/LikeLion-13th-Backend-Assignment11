package com.kimminwoo.multpartfile_assignment.member.domain.repository;

import com.kimminwoo.multpartfile_assignment.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
