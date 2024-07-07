package umc6th.spring.apiPayload.exception.handler;

import umc6th.spring.apiPayload.code.BaseErrorCode;
import umc6th.spring.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
