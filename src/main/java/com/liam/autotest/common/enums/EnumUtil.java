package com.liam.autotest.common.enums;

import java.util.Arrays;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
public class EnumUtil {

    public static <T extends CodeEnumParent> boolean isCodeExist(Integer code,Class<T> checkEnum) {
        T[] enumConstants = checkEnum.getEnumConstants();

        if (enumConstants == null || enumConstants.length == 0) {
            return false;
        }

        return Arrays.stream(enumConstants).anyMatch((enumConstant) -> enumConstant.getCode().equals(code));
    }
}
