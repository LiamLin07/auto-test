package com.liam.autotest.common.handler;

import com.liam.autotest.common.exception.ValidationException;
import com.liam.autotest.common.result.ResultVO;
import com.liam.autotest.common.result.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResultVO handleValidationException(ValidationException validationException) {
        log.info("valid failed", validationException);
        return ResultVOUtil.failed(validationException.getCode(), validationException.getMessage());
    }

}
