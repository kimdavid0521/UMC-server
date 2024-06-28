package umc.springdevelop.converter;

import umc.springdevelop.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO() {
        return TempResponse.TempTestDTO.builder()
                .testString("this is test")
                .build();
    }

    public static TempResponse.TempExceptionTestDTO toTempExceptionDTO(Integer flag) {
        return TempResponse.TempExceptionTestDTO.builder()
                .flag(flag)
                .build();
    }
}
