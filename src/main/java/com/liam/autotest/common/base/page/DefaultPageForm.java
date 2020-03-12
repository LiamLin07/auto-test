package com.liam.autotest.common.base.page;

import lombok.Data;

import java.util.List;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Data
public class DefaultPageForm {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 分页条件
     */
    private List<PageCondition> conditions;
}
