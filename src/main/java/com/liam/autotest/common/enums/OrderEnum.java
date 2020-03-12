package com.liam.autotest.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author Liam
 * @Date 2020/3/7
 */

@AllArgsConstructor
public enum OrderEnum implements CodeEnumParent {
    /**
     * 升序
     */
    ASC(1),
    /**
     * 降序
     */
    DESC(0),
    ;

    @Getter
    private Integer code;

}
