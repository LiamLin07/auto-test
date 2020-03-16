package com.liam.autotest.common.base.property;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Author Liam
 * @Date 2020/3/17
 */
@Data
public class BasePropertyForm {
    /**
     * 创建人id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createUserId;
    /**
     * 创建人姓名
     */
    private String createUserName;
    /**
     * 创建日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 最后修改人id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long lastModifyUserId;
    /**
     * 最后修改人姓名
     */
    private String lastModifyUserName;
    /**
     * 最后修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifyTime;
}
