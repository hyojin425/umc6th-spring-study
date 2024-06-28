package umc6th.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc6th.spring.domain.Mission;
import umc6th.spring.domain.Store;
import umc6th.spring.repository.MissionRepository;
import umc6th.spring.repository.StoreRepository;
import umc6th.spring.web.converter.MissionConverter;
import umc6th.spring.web.dto.missionDTO.MissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService{

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    @Override
    @Transactional
    public Mission missionRegister(MissionRequestDTO.MissionRegisterDto request, Long storeId){

        Store store = storeRepository.getById(storeId);
        Mission newMission = MissionConverter.toMission(request,store);
        return missionRepository.save(newMission);
    }
}
