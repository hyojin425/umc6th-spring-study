package umc6th.spring.web.dto.missionDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class MissionRegisterDto {
        @NotNull
        Integer reward;
        LocalDate deadLine;
        @NotBlank
        String missionSpec;
    }
}
