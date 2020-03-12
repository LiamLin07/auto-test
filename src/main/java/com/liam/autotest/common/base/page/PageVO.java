package com.liam.autotest.common.base.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author Liam
 * @Date 2020/3/9
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageVO<T> {
    private Long total;
    private List<T> content;
}
