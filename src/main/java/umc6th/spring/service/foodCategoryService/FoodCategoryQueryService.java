package umc6th.spring.service.foodCategoryService;

import java.util.List;

public interface FoodCategoryQueryService {

    boolean allCategoriesExist(List<Long> categoryIds);
}
