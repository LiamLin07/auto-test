package com.liam.autotest.sys.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.liam.autotest.common.base.property.BasePropertyForm;
import lombok.*;

import java.util.Date;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProjectListVO extends BasePropertyForm {

    /**
     * 项目id
     */
    @JsonSerialize(using = ToStringSerializer.class)
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


