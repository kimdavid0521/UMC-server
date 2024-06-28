package umc.springdevelop.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.springdevelop.apiPayload.code.BaseCode;
import umc.springdevelop.apiPayload.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)  //result 필드값이 null이라면 json 직렬화에서 제외된다는 뜻
    private T result;  //결과 데이터를 나타내며 제네릭 타입을 사용하여서 다양한 타입의 데이터를 수용할 수 있음.

    //실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {  //result는 어떤 값이 올지 모르기에 제네릭으로 설정(T)
        return new ApiResponse<>(false, code, message, data);
    }

    //성공한 경우 응답 생성
    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result) {
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), result);
    }
}
