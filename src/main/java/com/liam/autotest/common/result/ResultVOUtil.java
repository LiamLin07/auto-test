package com.liam.autotest.common.result;

import com.liam.autotest.common.enums.BaseEnum;

/**
 * @Author Liam
 * @Date 2020/3/7
 */
public class ResultVOUtil {

    public static Integer SUCCESS = 0;

    public static String SUCCESS_MSG = "success";

    public static <T> ResultVO<T> success() {
        return success(null);
    }

    public static <T> ResultVO<T> success(T data) {
        return ResultVO.<T>builder()
                .code(SUCCESS)
                .msg(SUCCESS_MSG)
                .data(data).build();
    }

    public static <T> ResultVO<T> failed(Integer code, String msg) {
        return ResultVO.<T>builder()
                .code(code)
                .msg(msg)
                .build();
    }

    public static <T, E extends BaseEnum> ResultVO<T> failed(E baseEnum) {
        return failed(baseEnum.getCode(), baseEnum.getMessage());
    }

    public static <T> ResultVO<T> successOrFailed(boolean isSuccess,Integer failedCode,String failedMsg) {
        if (isSuccess) {
            return success();
        }else {
            return failed(failedCode, failedMsg);
        }
    }

    public static <T, E extends BaseEnum> ResultVO<T> successOrFailed(boolean isSuccess,E failedEnum) {
        if (isSuccess) {
            return success();
        }else {
            return failed(failedEnum.getCode(), failedEnum.getMessage());
        }
    }
}
