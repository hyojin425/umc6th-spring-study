package umc6th.spring.service.storeService;

import org.springframework.data.domain.Page;
import umc6th.spring.domain.Mission;
import umc6th.spring.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long storeId);

    Page<Mission> getMissionList(Long StoreId, Integer page);
}
