package com.liam.autotest.common.base.property;

import com.liam.autotest.common.enums.EnabledEnum;

import java.util.Date;

/**
 * @Author Liam
 * @Date 2020/3/7
 */
public class BasePropertyPOUtil {


    public static <T extends BasePropertyPO> void init(T baseProperty, Long userId, String userName) {
        Date now = new Date();

        // 创建信息
        baseProperty.setCreateUserId(userId);
        baseProperty.setCreateName(userName);
        baseProperty.setCreateDate(now);

        // 修改信息
        baseProperty.setLastModifyUserId(userId);
        baseProperty.setLastModifyName(userName);
        baseProperty.setLastModifyDate(now);
        baseProperty.setEnabled(EnabledEnum.ENABLE.getCode());
    }

    public static <T extends BasePropertyPO> void modify(T baseProperty, Long userId, String userName) {
        Date now = new Date();
        // 修改信息
        baseProperty.setLastModifyUserId(userId);
        baseProperty.setLastModifyName(userName);
        baseProperty.setLastModifyDate(now);
    }

    public static <T extends BasePropertyPO> void delete(T baseProperty, Long userId, String userName) {
        Date now = new Date();
        // 删除信息
        baseProperty.setLastModifyUserId(userId);
        baseProperty.setLastModifyName(userName);
        baseProperty.setLastModifyDate(now);
        baseProperty.setEnabled(EnabledEnum.ENABLE.getCode());
    }

}
