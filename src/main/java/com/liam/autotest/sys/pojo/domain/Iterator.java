package com.liam.autotest.sys.pojo.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liam.autotest.common.base.property.BasePropertyPO;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@TableName(value = "iterator")
public class Iterator extends BasePropertyPO {
    /**
     * 项目id
     */
    @TableField(value = "project_id")
    private Long projectId;

    /**
     * 迭代名称
     */
    @TableField(value = "iterator_name")
    private String iteratorName;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

}