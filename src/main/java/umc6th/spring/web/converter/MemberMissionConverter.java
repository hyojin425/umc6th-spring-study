package umc6th.spring.web.converter;

import org.springframework.data.domain.Page;
import umc6th.spring.domain.*;
import umc6th.spring.domain.enums.MissionStatus;
import umc6th.spring.domain.mapping.MemberMission;
import umc6th.spring.web.dto.memberDTO.MemberResponseDTO;
import umc6th.spring.web.dto.missionDTO.MissionResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MemberResponseDTO.MemberMissionPreViewDTO memberMissionPreViewDTO(MemberMission memberMission){
        return MemberResponseDTO.MemberMissionPreViewDTO.builder()
                .reward(memberMission.getMission().getReward())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .deadLine(memberMission.getMission().getDeadline())
                .storeName(memberMission.getMission().getStore().getName())
                .build();
    }

    public static MemberResponseDTO.MemberMissionPreviewListDTO memberMissionPreViewListDTO(Page<MemberMission> memberMissionList){

        List<MemberResponseDTO.MemberMissionPreViewDTO> missionPreViewDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::memberMissionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MemberMissionPreviewListDTO.builder()
                .isLast(memberMissionList.isLast())
                .isFirst(memberMissionList.isFirst())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .memberMissionList(missionPreViewDTOList)
                .build();
    }

}
