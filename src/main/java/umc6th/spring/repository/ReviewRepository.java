package umc6th.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc6th.spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
