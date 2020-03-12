package com.liam.autotest.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liam.autotest.sys.dao.IteratorMapper;
import com.liam.autotest.sys.pojo.domain.Iterator;
import com.liam.autotest.sys.service.IteratorValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 * @Author Liam
 * @Date 2020/3/9
 */
@Slf4j
@Service
public class IteratorValidationServiceImpl implements IteratorValidationService {

    @Autowired
    private IteratorMapper iteratorMapper;

    @Override
    public boolean isProjectIdRelateByIterator(Long projectId) {
        LambdaQueryWrapper<Iterator> iteratorWrapper = Wrappers.<Iterator>lambdaQuery();
        iteratorWrapper.eq(Iterator::getProjectId, projectId);
        return iteratorMapper.selectCount(iteratorWrapper) > 0;
    }

    @Override
    public boolean isIteratorIdExist(Long iteratorId) {
        LambdaQueryWrapper<Iterator> iteratorWrapper = Wrappers.<Iterator>lambdaQuery();
        iteratorWrapper.eq(Iterator::getId, iteratorId);
        return iteratorMapper.selectCount(iteratorWrapper) > 0;
    }
}
