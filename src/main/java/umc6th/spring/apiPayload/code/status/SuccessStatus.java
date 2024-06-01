package umc6th.spring.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc6th.spring.apiPayload.code.BaseCode;
import umc6th.spring.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    _OK(HttpStatus.OK, "2000", "OK");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return null;
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return null;
    }
}
