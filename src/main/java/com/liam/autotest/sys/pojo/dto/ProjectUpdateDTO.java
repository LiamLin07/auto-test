package com.liam.autotest.sys.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectUpdateDTO {
    /**
     * 项目id
     */
    private Long id;
    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 备注
     */
    private String remark;
}
