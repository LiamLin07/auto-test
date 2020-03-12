package com.liam.autotest.sys.pojo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Data
public class ProjectUpdateForm {
    /**
     * 项目id
     */
    @NotNull(message = "项目id不能为空")
    private Long id;
    /**
     * 项目名称
     */
    @NotEmpty(message = "项目名称不能为空")
    private String projectName;

    /**
     * 备注
     */
    private String remark;
}
