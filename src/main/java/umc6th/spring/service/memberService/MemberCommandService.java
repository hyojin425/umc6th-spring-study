package umc6th.spring.service.memberService;

import umc6th.spring.domain.Member;
import umc6th.spring.web.dto.memberDTO.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
