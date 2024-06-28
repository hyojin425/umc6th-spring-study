package umc6th.spring.web.dto.reviewDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class ReviewRegisterDto {
        @NotBlank
        String title;
        @NotNull
        Float score;
    }

}
