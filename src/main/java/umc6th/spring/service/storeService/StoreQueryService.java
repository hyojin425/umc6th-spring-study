package umc6th.spring.service.storeService;

import umc6th.spring.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long storeId);
}
