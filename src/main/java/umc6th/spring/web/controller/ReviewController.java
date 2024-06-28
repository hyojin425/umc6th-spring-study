package umc6th.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc6th.spring.apiPayload.ApiResponse;
import umc6th.spring.domain.Review;
import umc6th.spring.service.reviewService.ReviewCommandService;
import umc6th.spring.validation.annotation.ExistStore;
import umc6th.spring.web.converter.ReviewConverter;
import umc6th.spring.web.dto.reviewDTO.ReviewRequestDTO;
import umc6th.spring.web.dto.reviewDTO.ReviewResponseDTO;


@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
@Validated
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.ReviewResultDto> register(@RequestBody @Valid ReviewRequestDTO.ReviewRegisterDto request,
                                                              @RequestParam Long memberId, @RequestParam @ExistStore Long storeId)
    {
        Review review = reviewCommandService.ReviewRegister(request, memberId,storeId);
        ReviewResponseDTO.ReviewResultDto resultDto = ReviewConverter.toReviewResult(review);
        return ApiResponse.onSuccess(resultDto);
    }
}
