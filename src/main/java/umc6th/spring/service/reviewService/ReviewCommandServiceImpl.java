package umc6th.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc6th.spring.domain.Member;
import umc6th.spring.domain.Review;
import umc6th.spring.domain.Store;
import umc6th.spring.repository.MemberRepository;
import umc6th.spring.repository.ReviewRepository;
import umc6th.spring.repository.StoreRepository;
import umc6th.spring.web.converter.ReviewConverter;
import umc6th.spring.web.dto.reviewDTO.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    @Override
    @Transactional
    public Review ReviewRegister(ReviewRequestDTO.ReviewRegisterDto request, Long memberId, Long storeId) {

        Store store = storeRepository.getById(storeId);
        Member member = memberRepository.getById(memberId);
        Review newReview = ReviewConverter.toReview(request, member, store);
        return reviewRepository.save(newReview);
    }
}

