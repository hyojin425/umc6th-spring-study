package umc6th.spring.apiPayload.exception.handler;

import umc6th.spring.apiPayload.code.BaseErrorCode;
import umc6th.spring.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
