package com.liam.autotest.sys.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @Author Liam
 * @Date 2020/3/10
 */
@Data
public class IteratorListVO {
    /**
     * 表id
     */
    private Long id;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 迭代名称
     */
    private String iteratorName;

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
    private Date lastModifyDate;
}
