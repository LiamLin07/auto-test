package com.liam.autotest.sys.pojo.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.liam.autotest.common.base.property.BasePropertyPO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "project")
public class Project extends BasePropertyPO {

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 备注
     */
    private String remark;
}