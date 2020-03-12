package com.liam.autotest.dao;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liam.autotest.common.base.property.BasePropertyPOUtil;
import com.liam.autotest.common.constant.DefaultUser;
import com.liam.autotest.sys.dao.IteratorMapper;
import com.liam.autotest.sys.pojo.domain.Iterator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class IteratorMapperTest {

    @Autowired
    private IteratorMapper iteratorMapper;

    @Test
    public void testSelect() {
        for (long i = 0; i < 500; i++) {
            Iterator testIterator = createIterator(i, "testIterator" + i, "testRemark");
            int insert = iteratorMapper.insert(testIterator);
        }
    }

    @Test
    public void testCondition() {
        List<OrderItem> iteratorName = OrderItem.ascs("iterator_name");
        Page<Iterator> iteratorPage = new Page<>(1, 10);
        iteratorPage.setOrders(iteratorName);
        Page<Iterator> iteratorPage1 = iteratorMapper.selectPage(iteratorPage, null);
        System.out.println(iteratorPage1);
    }

    private Iterator createIterator(Long projectId,String iteratorName,String remark) {
        Iterator iterator = new Iterator();
        iterator.setProjectId(projectId);
        iterator.setIteratorName(iteratorName);
        iterator.setRemark(remark);

        BasePropertyPOUtil.init(iterator, DefaultUser.userId, DefaultUser.userName);
        return iterator;
    }

}