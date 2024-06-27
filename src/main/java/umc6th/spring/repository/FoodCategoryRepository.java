package umc6th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
