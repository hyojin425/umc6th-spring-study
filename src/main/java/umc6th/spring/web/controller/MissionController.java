package umc6th.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc6th.spring.apiPayload.ApiResponse;
import umc6th.spring.domain.Mission;
import umc6th.spring.service.missionService.MissionCommandService;
import umc6th.spring.validation.annotation.ExistStore;
import umc6th.spring.web.converter.MissionConverter;
import umc6th.spring.web.dto.missionDTO.MissionRequestDTO;
import umc6th.spring.web.dto.missionDTO.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
@Validated
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.MissionResultDto> MissionRegister(@RequestBody @Valid MissionRequestDTO.MissionRegisterDto request, @RequestParam Long storeId){
        Mission mission = missionCommandService.missionRegister(request,storeId);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDto(mission));
    }
}
