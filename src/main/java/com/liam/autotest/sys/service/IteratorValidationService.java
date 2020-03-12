package com.liam.autotest.sys.service;

/**
 * @Author Liam
 * @Date 2020/3/9
 */
public interface IteratorValidationService {
    /**
     * 判断项目id是否被迭代关联
     *
     * @param projectId
     * @return
     */
    boolean isProjectIdRelateByIterator(Long projectId);

    /**
     * 判断迭代id是否存在
     *
     * @param iteratorId
     * @return
     */
    boolean isIteratorIdExist(Long iteratorId);
}
