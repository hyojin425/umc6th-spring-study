package umc6th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
