package umc6th.spring.apiPayload.exception.handler;

import umc6th.spring.apiPayload.code.BaseErrorCode;
import umc6th.spring.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode code) {
        super(code);
    }
}
