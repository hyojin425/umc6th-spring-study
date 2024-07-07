package umc6th.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc6th.spring.apiPayload.ApiResponse;
import umc6th.spring.domain.Mission;
import umc6th.spring.domain.mapping.MemberMission;
import umc6th.spring.service.memberMissionService.MemberMissionCommandService;
import umc6th.spring.service.missionService.MissionCommandService;
import umc6th.spring.web.converter.MemberMissionConverter;
import umc6th.spring.web.converter.MissionConverter;
import umc6th.spring.web.dto.missionDTO.MissionRequestDTO;
import umc6th.spring.web.dto.missionDTO.MissionResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
@Validated
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.MissionResultDto> missionRegister(@RequestBody @Valid MissionRequestDTO.MissionRegisterDto request, @RequestParam Long storeId){
        Mission mission = missionCommandService.missionRegister(request,storeId);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDto(mission));
    }

    @PostMapping("/join/{missionId}")
    public ApiResponse<MissionResponseDTO.MissionJoinResultDto> missionJoin(@RequestParam Long memberId, @PathVariable Long missionId){
        MemberMission memberMission = memberMissionCommandService.jointMission(memberId,missionId);
        return ApiResponse.onSuccess(MemberMissionConverter.toMissionJointResultDto(memberMission));
    }
}
