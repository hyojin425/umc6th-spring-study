package umc6th.spring.service.missionService;

import umc6th.spring.domain.Mission;
import umc6th.spring.web.dto.missionDTO.MissionRequestDTO;

public interface MissionCommandService {
    Mission missionRegister(MissionRequestDTO.MissionRegisterDto request, Long storeId);
}
