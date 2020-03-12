package com.liam.autotest.common.base.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liam.autotest.common.enums.EnumUtil;
import com.liam.autotest.common.enums.OrderEnum;
import com.liam.autotest.common.enums.ValidationEnum;
import com.liam.autotest.common.exception.ValidationException;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
public class PageUtil {

    private static String UNDER_LINE = "_";

    public static <E extends DefaultPageForm, T> Page<T> getPage(E pageForm) {
        return getPage(pageForm, PageConstant.defaultPageNum, PageConstant.defaultPageSize, null);
    }

    public static <E extends DefaultPageForm, T> Page<T> getPage(E pageForm, Integer defaultPageNum, Integer defaultPageSize, List<PageCondition> defaultPageCondition) {

        Integer pageNum = Optional.ofNullable(pageForm.getPageNum()).orElse(defaultPageNum);
        Integer pageSize = Optional.ofNullable(pageForm.getPageSize()).orElse(defaultPageSize);
        List<PageCondition> pageConditions = Optional.ofNullable(pageForm.getConditions()).orElse(defaultPageCondition);

        List<OrderItem> orderItemList = getOrderItemsByPageCondition(pageConditions);

        Page<T> page = new Page<>(pageNum, pageSize);
        page.setOrders(orderItemList);
        return page;
    }

    public static <T> Page<T> getPage(int pageNum, int pageSize, List<PageCondition> pageConditionList) {
        List<OrderItem> orderItemList = getOrderItemsByPageCondition(pageConditionList);
        Page<T> page = new Page<>(pageNum, pageSize);
        page.setOrders(orderItemList);
        return page;
    }

    public static <E> PageVO<E> getPageVO(Long total, List<E> list) {
        return PageVO.<E>builder()
                .total(total)
                .content(list).build();

    }

    public static <T> PageVO<T> getPageVO(IPage<T> iPage) {
        return PageVO.<T>builder()
                .total(iPage.getTotal())
                .content(iPage.getRecords()).build();
    }

    private static List<OrderItem> getOrderItemsByPageCondition(List<PageCondition> pageConditionList) {
        List<OrderItem> orderItemList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(pageConditionList)) {
            orderItemList = pageConditionList.stream()
                    .filter(pageCondition -> EnumUtil.isCodeExist(pageCondition.getOrderCode(), OrderEnum.class))
                    .map(pageCondition -> {
                        String dbColumnName = columnCamelToUnderLine(pageCondition.getColumnName());
                        if (OrderEnum.ASC.getCode().equals(pageCondition.getOrderCode())) {
                            return OrderItem.asc(dbColumnName);
                        } else {
                            return OrderItem.desc(dbColumnName);
                        }
                    }).collect(Collectors.toList());
        }
        return orderItemList;
    }

    private static String columnCamelToUnderLine(String camelColumnName) {
        StringBuilder sb = new StringBuilder(camelColumnName);
        int index = 0;//定位
        if (!camelColumnName.contains(UNDER_LINE)) {
            for (int i = 0; i < camelColumnName.length(); i++) {
                if (Character.isUpperCase(camelColumnName.charAt(i))) {
                    sb.insert(i + index, "_");
                    index += 1;
                }
            }
        }
        return sb.toString().toLowerCase();
    }

}
