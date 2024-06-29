package umc6th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
