package com.liam.autotest.sys.pojo.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Data
public class ProjectDeleteForm {

    @NotNull(message = "项目id不可以为空")
    private Long id;
}
