package umc.springdevelop.apiPayload.code;

public interface BaseCode {   //이를 구체화하는 status에서 두개의 메서드를 반드시 override할것을 강제함

    public ReasonDTO getReason();

    public ReasonDTO getReasonHttpStatus();
}
