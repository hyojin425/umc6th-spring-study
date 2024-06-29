package umc6th.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc6th.spring.apiPayload.ApiResponse;
import umc6th.spring.domain.Review;
import umc6th.spring.service.reviewService.ReviewCommandService;
import umc6th.spring.service.reviewService.ReviewQueryService;
import umc6th.spring.validation.annotation.CheckPage;
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
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/register")
    public ApiResponse<ReviewResponseDTO.ReviewResultDto> register(@RequestBody @Valid ReviewRequestDTO.ReviewRegisterDto request,
                                                              @RequestParam Long memberId, @RequestParam @ExistStore Long storeId)
    {
        Review review = reviewCommandService.ReviewRegister(request, memberId,storeId);
        ReviewResponseDTO.ReviewResultDto resultDto = ReviewConverter.toReviewResult(review);
        return ApiResponse.onSuccess(resultDto);
    }

    @GetMapping("/{storeId}")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") @CheckPage Integer page){
        Page<Review> reviewPage = reviewQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewPage));
    }
}
