package umc.springdevelop.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.springdevelop.apiPayload.code.BaseErrorCode;
import umc.springdevelop.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}