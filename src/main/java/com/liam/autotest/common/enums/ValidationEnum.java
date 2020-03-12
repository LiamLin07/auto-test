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
public enum ValidationEnum implements BaseEnum {

    REQUEST_PARAM_ERROR(90001, "请求参数错误"),
    PAGE_PARAM_ERROR(90001, "分页参数错误"),
    COLUMN_NAME_ERROR(90002, "列名必须为驼峰命名"),
    ORDER_CODE_ERROR(90003, "排序code必须为0-1"),
    PROJECT_ID_NOT_EXIST(90004, "项目ID不存在"),
    PROJECT_ID_RELATED_BY_ITERATOR(90005, "项目id被迭代关联")
    ;

    private Integer code;
    private String message;

}