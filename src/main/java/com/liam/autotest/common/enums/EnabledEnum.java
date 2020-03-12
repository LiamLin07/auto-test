package com.liam.autotest.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Liam
 * @Date 2020/3/7
 */

@Getter
@AllArgsConstructor
public enum EnabledEnum implements BaseEnum {
    /**
     * 未删除
     */
    ENABLE(1,"未删除"),
    /**
     * 已删除
     */
    DISABLE(0,"已删除"),
    ;

    private Integer code;

    private String message;

}
