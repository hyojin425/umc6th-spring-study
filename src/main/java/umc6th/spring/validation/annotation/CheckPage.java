package umc6th.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc6th.spring.validation.validator.CheckPageValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

    String message() default "페이지 범위를 벗어났습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
