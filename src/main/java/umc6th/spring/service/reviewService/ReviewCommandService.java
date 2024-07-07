package umc6th.spring.service.reviewService;

import umc6th.spring.domain.Review;
import umc6th.spring.web.dto.reviewDTO.ReviewRequestDTO;

public interface ReviewCommandService {
    Review ReviewRegister(ReviewRequestDTO.ReviewRegisterDto request, Long memberId, Long storeId);
}
