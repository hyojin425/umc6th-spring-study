package umc6th.spring.service.memberService;

import umc6th.spring.domain.Member;
import umc6th.spring.web.dto.memberDTO.MemberRequestDTO;

import java.util.List;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}
