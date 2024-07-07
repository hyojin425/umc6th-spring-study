package umc6th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
