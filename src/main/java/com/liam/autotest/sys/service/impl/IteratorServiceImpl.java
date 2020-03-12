package com.liam.autotest.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liam.autotest.common.base.property.BasePropertyPOUtil;
import com.liam.autotest.common.constant.DefaultUser;
import com.liam.autotest.common.enums.EnabledEnum;
import com.liam.autotest.common.enums.ValidationEnum;
import com.liam.autotest.common.exception.ValidationException;
import com.liam.autotest.sys.dao.IteratorMapper;
import com.liam.autotest.sys.pojo.domain.Iterator;
import com.liam.autotest.sys.pojo.vo.IteratorListVO;
import com.liam.autotest.sys.service.IteratorService;
import com.liam.autotest.sys.service.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Consumer;

/**
 * @Author Liam
 * @Date 2020/3/9
 */
@Service
public class IteratorServiceImpl implements IteratorService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IteratorMapper iteratorMapper;

    @Override
    public int addIterator(String iteratorName, Long projectId, String remark) {

        if (StringUtils.isBlank(iteratorName) || projectId == null) {
            throw new ValidationException(ValidationEnum.REQUEST_PARAM_ERROR);
        }

        Iterator iterator = createIteratorByParam(null, iteratorName, projectId, remark,
                (consumedIterator) -> BasePropertyPOUtil.init(consumedIterator, DefaultUser.userId, DefaultUser.userName));
        return iteratorMapper.insert(iterator);
    }

    @Override
    public int deleteIteratorById(Long iteratorId) {
        if (iteratorId == null) {
            return 0;
        }

        Date now = new Date();

        LambdaUpdateWrapper<Iterator> iteratorLambdaUpdateWrapper = Wrappers.<Iterator>lambdaUpdate();
        iteratorLambdaUpdateWrapper.eq(Iterator::getId, iteratorId)
                .set(Iterator::getEnabled, EnabledEnum.DISABLE.getCode())
                .set(Iterator::getLastModifyDate, now)
                .set(Iterator::getLastModifyUserId, DefaultUser.userId)
                .set(Iterator::getLastModifyName, DefaultUser.userName);

        return iteratorMapper.update(null,iteratorLambdaUpdateWrapper);
    }

    @Override
    public int updateIteratorById(Long iteratorId, String iteratorName, Long projectId, String remark) {
        if (iteratorId == null || StringUtils.isBlank(iteratorName) || projectId == null) {
            throw new ValidationException(ValidationEnum.REQUEST_PARAM_ERROR);
        }
        Iterator iterator = createIteratorByParam(iteratorId, iteratorName, projectId, remark,
                (consumedIterator)->BasePropertyPOUtil.modify(consumedIterator, DefaultUser.userId, DefaultUser.userName));
        return iteratorMapper.updateById(iterator);
    }

    @Override
    public IPage<Iterator> selectIteratorByPage(Page<Iterator> page) {
        if (page == null) {
            return null;
        }
        return iteratorMapper.selectPage(page, null);
    }

    @Override
    public IPage<IteratorListVO> selectIteratorVOByPage(Page<Iterator> page) {
        if (page == null) {
            return null;
        }
        return iteratorMapper.selectByIteratorListByPage(page);
    }

    private Iterator createIteratorByParam(Long iteratorId, String iteratorName, Long projectId, String remark, Consumer<Iterator> iteratorConsumer) {
        Iterator createdIterator = Iterator.builder()
                .iteratorName(iteratorName)
                .projectId(projectId)
                .remark(remark).build();
        createdIterator.setId(iteratorId);
        iteratorConsumer.accept(createdIterator);
        return createdIterator;
    }
}
