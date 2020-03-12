package com.liam.autotest.sys.pojo.dto;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCreateDTO {
    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 备注
     */
    private String remark;
}