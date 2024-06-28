package umc.springdevelop.service.tempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.springdevelop.apiPayload.code.status.ErrorStatus;
import umc.springdevelop.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{
    @Override
    public void checkFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}