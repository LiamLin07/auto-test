package com.liam.autotest.sys.pojo.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Liam
 * @Date 2020/3/9
 */
@Data
public class IteratorDeleteForm {
    @NotNull(message = "迭代id不能为空")
    private Long iteratorId;
}
