package com.liam.autotest.sys.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectListVO {

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

    /**
     * 创建人id
     */
    private Long createUserId;
    /**
     * 创建人姓名
     */
    private String createName;
    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    /**
     * 最后修改人id
     */
    private Long lastModifyUserId;
    /**
     * 最后修改人姓名
     */
    private String lastModifyName;
    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifyDate;
}
