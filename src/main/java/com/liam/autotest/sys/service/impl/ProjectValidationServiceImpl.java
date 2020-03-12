package com.liam.autotest.sys.service.impl;

import com.liam.autotest.common.enums.ValidationEnum;
import com.liam.autotest.common.exception.ValidationException;
import com.liam.autotest.sys.dao.ProjectMapper;
import com.liam.autotest.sys.service.ProjectValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Liam
 * @Date 2020/3/9
 */
@Slf4j
@Service
public class ProjectValidationServiceImpl implements ProjectValidationService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public boolean isProjectIdExist(Long projectId) {
        if (projectId == null) {
            return false;
        }

        return projectMapper.selectById(projectId) != null;
    }

    @Override
    public void validProjectId(Long projectId) {
        if (!isProjectIdExist(projectId)) {
            throw new ValidationException(ValidationEnum.PROJECT_ID_NOT_EXIST);
        }
    }
}
