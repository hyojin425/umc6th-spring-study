package umc6th.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc6th.spring.domain.Member;
import umc6th.spring.domain.mapping.MemberMission;
import umc6th.spring.repository.MemberMissionRepository;
import umc6th.spring.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();

        Page<MemberMission> memberMissionPage = memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));
        return memberMissionPage;
    }
}
