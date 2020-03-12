package com.liam.autotest.common.enums;

import com.liam.autotest.common.exception.BaseException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
public class ExceptionUtil {

    public static <E extends BaseEnum, T extends BaseException> T getException(E actualEnum, Class<T> actualExceptionClass) {
        try {
            Constructor<T> constructor = actualExceptionClass.getConstructor(Integer.class, String.class);
            return constructor.newInstance(actualEnum.getCode(), actualEnum.getMessage());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
