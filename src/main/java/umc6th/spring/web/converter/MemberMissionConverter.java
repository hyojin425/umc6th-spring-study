package umc6th.spring.web.converter;

import umc6th.spring.domain.*;
import umc6th.spring.domain.enums.MissionStatus;
import umc6th.spring.domain.mapping.MemberMission;
import umc6th.spring.web.dto.missionDTO.MissionResponseDTO;

import java.time.LocalDate;

public class MemberMissionConverter {

    public static MissionResponseDTO.MissionJoinResultDto toMissionJointResultDto(MemberMission memberMission){
        return MissionResponseDTO.MissionJoinResultDto.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDate.now())
                .build();
    }

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGE)
                .member(member)
                .mission(mission)
                .build();
    }

}
