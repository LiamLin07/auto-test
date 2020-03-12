package com.liam.autotest.common.base.page;

import lombok.Data;

/**
 * 分页条件
 *
 * @Author Liam
 * @Date 2020/3/8
 */
@Data
public class PageCondition {
    /**
     * 列名称
     */
    private String columnName;
    /**
     * 排序 0 升序 1 降序
     */
    private Integer orderCode;
}
