package com.liam.autotest.sys.pojo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liam.autotest.common.base.property.BasePropertyPO;
import java.util.Date;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName(value = "project")
public class Project extends BasePropertyPO {
    /**
     * 项目名称
     */
    @TableField(value = "project_name")
    private String projectName;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;
}