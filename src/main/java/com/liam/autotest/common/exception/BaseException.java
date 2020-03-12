package com.liam.autotest.common.exception;

import com.liam.autotest.common.enums.BaseEnum;
import lombok.Getter;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Getter
public abstract class BaseException extends RuntimeException {

    /**
     * 异常状态码
     */
    private Integer code;

    public BaseException(Integer code, String message) {
        super(message);
        this.code = code;
    }


}
