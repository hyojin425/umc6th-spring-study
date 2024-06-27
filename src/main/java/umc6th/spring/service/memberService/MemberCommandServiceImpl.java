package umc6th.spring.service.memberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc6th.spring.apiPayload.code.status.ErrorStatus;
import umc6th.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc6th.spring.domain.FoodCategory;
import umc6th.spring.domain.Member;
import umc6th.spring.domain.mapping.MemberPrefer;
import umc6th.spring.repository.FoodCategoryRepository;
import umc6th.spring.repository.MemberRepository;
import umc6th.spring.web.converter.MemberConverter;
import umc6th.spring.web.converter.MemberPreferConverter;
import umc6th.spring.web.dto.memberDTO.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
