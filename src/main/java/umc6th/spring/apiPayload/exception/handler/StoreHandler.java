package umc6th.spring.apiPayload.exception.handler;

import umc6th.spring.apiPayload.code.BaseErrorCode;
import umc6th.spring.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode code) {
        super(code);
    }
}
