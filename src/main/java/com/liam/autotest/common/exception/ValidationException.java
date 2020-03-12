package com.liam.autotest.common.exception;

import com.liam.autotest.common.enums.BaseEnum;

/**
 * 校验异常
 *
 * @Author Liam
 * @Date 2020/3/8
 */
public class ValidationException extends BaseException {

    public ValidationException(Integer code, String message) {
        super(code, message);
    }

    public <T extends BaseEnum> ValidationException(T exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMessage());
    }
}
