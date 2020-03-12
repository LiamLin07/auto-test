package com.liam.autotest.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liam.autotest.sys.pojo.domain.Iterator;
import com.liam.autotest.sys.pojo.vo.IteratorListVO;

/**
 * @Author Liam
 * @Date 2020/3/9
 */
public interface IteratorService {

    /**
     * 添加迭代
     *
     * @param iteratorName 迭代名称
     * @param projectId    迭代id
     * @param remark       备注
     * @return
     */
    int addIterator(String iteratorName, Long projectId, String remark);

    /**
     * 删除迭代
     *
     * @param iteratorId 迭代id
     * @return
     */
    int deleteIteratorById(Long iteratorId);

    /**
     * 根据id更新迭代
     *
     * @param iteratorId   迭代id
     * @param iteratorName 迭代名称
     * @param projectId    项目id
     * @param remark       备注
     * @return
     */
    int updateIteratorById(Long iteratorId, String iteratorName, Long projectId, String remark);

    /**
     * 分页查询迭代
     *
     * @param page 分页
     * @return
     */
    IPage<Iterator> selectIteratorByPage(Page<Iterator> page);

    /**
     * 分页获取列表数据
     *
     * @param page
     * @return
     */
    IPage<IteratorListVO> selectIteratorVOByPage(Page<Iterator> page);
}
