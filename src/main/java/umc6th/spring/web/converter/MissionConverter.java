package umc6th.spring.web.converter;

import org.springframework.data.domain.Page;
import umc6th.spring.domain.Mission;
import umc6th.spring.domain.Review;
import umc6th.spring.domain.Store;
import umc6th.spring.web.dto.missionDTO.MissionRequestDTO;
import umc6th.spring.web.dto.missionDTO.MissionResponseDTO;
import umc6th.spring.web.dto.reviewDTO.ReviewResponseDTO;
import umc6th.spring.web.dto.storeDTO.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return StoreResponseDTO.MissionPreViewDTO.builder()
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .deadLine(mission.getDeadline())
                .storeName(mission.getStore().getName())
                .build();
    }
    public static StoreResponseDTO.MissionPreviewListDTO missionPreViewListDTO(Page<Mission> missionList){

        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
