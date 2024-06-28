package umc.springdevelop.apiPayload.exception.handler;

import umc.springdevelop.apiPayload.code.BaseErrorCode;
import umc.springdevelop.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
