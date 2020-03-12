package com.liam.autotest.sys.pojo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author Liam
 * @Date 2020/3/9
 */
@Data
public class IteratorUpdateForm {
    @NotNull(message = "迭代id不能为空")
    private Long id;
    @NotEmpty(message = "迭代名称不能为空")
    private String iteratorName;
    @NotNull(message = "项目id不能为空")
    private Long projectId;
    private String remark;
}
