package umc6th.spring.service.foodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc6th.spring.repository.FoodCategoryRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService{

    private final FoodCategoryRepository foodCategoryRepository;


    @Override
    public boolean allCategoriesExist(List<Long> categoryIds) {
        return categoryIds.stream()
                .allMatch(foodCategoryRepository::existsById);
    }
}
