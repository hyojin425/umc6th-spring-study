package umc6th.spring.service.reviewService;

import org.springframework.data.domain.Page;
import umc6th.spring.domain.Review;

public interface ReviewQueryService {

    Page<Review> getReviewList(Long StoreId, Integer page);
}
