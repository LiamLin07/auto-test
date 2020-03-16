package com.liam.autotest.sys.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.liam.autotest.common.base.property.BasePropertyForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Author Liam
 * @Date 2020/3/10
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IteratorListVO extends BasePropertyForm {
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

}
