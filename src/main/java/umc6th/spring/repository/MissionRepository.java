package umc6th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>{}
