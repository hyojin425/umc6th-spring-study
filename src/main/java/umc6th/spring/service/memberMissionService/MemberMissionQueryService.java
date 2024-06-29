package umc6th.spring.service.memberMissionService;

import org.springframework.data.domain.Page;
import umc6th.spring.domain.mapping.MemberMission;

public interface MemberMissionQueryService {
    Page<MemberMission> getMemberMissionList(Long memberId, Integer page);
}
