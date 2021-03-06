package com.liam.autotest.common.base.property;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @Author Liam
 * @Date 2020/3/7
 */
@Data
public class BasePropertyPO {

    /**
     * 表id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 创建人id
     */
    private Long createUserId;
    /**
     * 创建人姓名
     */
    private String createUserName;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 最后修改人id
     */
    private Long lastModifyUserId;
    /**
     * 最后修改人姓名
     */
    private String lastModifyUserName;
    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    /**
     * 逻辑删除 1 未删除 0 已删除
     */
    @TableLogic(value = "1", delval = "0")
    private Integer enabled;


}
