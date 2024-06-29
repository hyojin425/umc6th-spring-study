package umc6th.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring.domain.Mission;
import umc6th.spring.domain.Store;

public interface MissionRepository extends JpaRepository<Mission, Long>{
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);

}
