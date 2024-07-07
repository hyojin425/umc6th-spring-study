package umc6th.spring.apiPayload.exception.handler;

import umc6th.spring.apiPayload.code.BaseErrorCode;
import umc6th.spring.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode code) {
        super(code);
    }
}
