package umc6th.spring.web.converter;

import umc6th.spring.domain.Mission;
import umc6th.spring.domain.Store;
import umc6th.spring.web.dto.missionDTO.MissionRequestDTO;
import umc6th.spring.web.dto.missionDTO.MissionResponseDTO;

public class MissionConverter {

    public static MissionResponseDTO.MissionResultDto toMissionResultDto(Mission mission){
        return MissionResponseDTO.MissionResultDto.builder()
                .missionId(mission.getId())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MissionRegisterDto request, Store store) {
        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadLine())
                .missionSpec(request.getMissionSpec())
                .store(store)
                .build();

    }
}
