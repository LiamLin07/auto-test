package com.liam.autotest.sys.service;

/**
 * @Author Liam
 * @Date 2020/3/9
 */
public interface ProjectValidationService {
    /**
     * 校验项目id是否存在
     *
     * @param projectId 项目id
     * @return
     */
    boolean isProjectIdExist(Long projectId);

    /**
     * 校验项目id是否正确
     *
     * @param projectId 项目id
     * @throws com.liam.autotest.common.exception.ValidationException 校验异常
     */
    void validProjectId(Long projectId);
}
