package umc6th.spring.web.converter;

import umc6th.spring.domain.*;
import umc6th.spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc6th.spring.web.dto.reviewDTO.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.ReviewResultDto toReviewResult(Review review){
        return ReviewResponseDTO.ReviewResultDto.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.ReviewRegisterDto request, Member member, Store store){

        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }
}
