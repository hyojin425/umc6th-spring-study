package umc6th.spring.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc6th.spring.apiPayload.code.status.ErrorStatus;
import umc6th.spring.domain.Store;
import umc6th.spring.repository.StoreRepository;
import umc6th.spring.service.storeService.StoreQueryService;
import umc6th.spring.validation.annotation.ExistStore;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StoreExistValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreQueryService storeQueryService;
    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        Optional<Store> target = storeQueryService.findStore(value);

        if(target.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }
        return true;
    }
}
