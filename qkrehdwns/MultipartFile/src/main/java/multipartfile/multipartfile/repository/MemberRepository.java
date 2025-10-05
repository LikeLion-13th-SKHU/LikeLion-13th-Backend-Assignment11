package multipartfile.multipartfile.repository;

import multipartfile.multipartfile.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
