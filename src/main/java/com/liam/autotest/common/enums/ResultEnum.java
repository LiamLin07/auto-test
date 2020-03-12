package com.liam.autotest.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 校验异常枚举
 *
 * @Author Liam
 * @Date 2020/3/8
 */
@Getter
@AllArgsConstructor
public enum ResultEnum implements BaseEnum {

    SERVER_ERROR(10001,"服务器异常！"),
    INSERT_FAILED(10002,"数据添加失败!"),
    DELETE_FAILED(10002,"数据删除失败！"),
    UPDATE_FAILED(10003,"数据更新失败！"),
    ;

    private Integer code;
    private String message;

}