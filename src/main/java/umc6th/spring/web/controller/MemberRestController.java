package umc6th.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc6th.spring.apiPayload.ApiResponse;
import umc6th.spring.domain.Member;
import umc6th.spring.service.memberService.MemberCommandService;
import umc6th.spring.web.converter.MemberConverter;
import umc6th.spring.web.dto.memberDTO.MemberRequestDTO;
import umc6th.spring.web.dto.memberDTO.MemberResponseDTO;

import static umc6th.spring.web.dto.memberDTO.MemberResponseDTO.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Validated
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
