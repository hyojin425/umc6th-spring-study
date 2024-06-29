package umc6th.spring.service.memberMissionService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc6th.spring.apiPayload.code.status.ErrorStatus;
import umc6th.spring.apiPayload.exception.handler.MemberHandler;
import umc6th.spring.apiPayload.exception.handler.MissionHandler;
import umc6th.spring.domain.Member;
import umc6th.spring.domain.Mission;
import umc6th.spring.domain.mapping.MemberMission;
import umc6th.spring.repository.MemberMissionRepository;
import umc6th.spring.repository.MemberRepository;
import umc6th.spring.repository.MissionRepository;
import umc6th.spring.web.converter.MemberMissionConverter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission jointMission(Long memberId, Long missionId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);
        return memberMissionRepository.save(memberMission);
    }
}
