package umc6th.spring.service.memberMissionService;

import org.springframework.transaction.annotation.Transactional;
import umc6th.spring.domain.mapping.MemberMission;

public interface MemberMissionCommandService {
    @Transactional
    MemberMission jointMission(Long memberId, Long missionId);
}
