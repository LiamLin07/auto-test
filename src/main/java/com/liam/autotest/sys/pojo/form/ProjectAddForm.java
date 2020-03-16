package com.liam.autotest.sys.pojo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Data
public class ProjectAddForm {
    /**
     * 项目名称
     */
    @Size(max = 32, message = "项目名称最长为32个字符")
    @NotEmpty(message = "项目名称不能为空")
    private String projectName;

    /**
     * 备注
     */
    private String remark;
}
