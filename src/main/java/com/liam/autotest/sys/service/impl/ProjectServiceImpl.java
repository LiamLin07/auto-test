package com.liam.autotest.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liam.autotest.common.base.property.BasePropertyPOUtil;
import com.liam.autotest.common.constant.DefaultUser;
import com.liam.autotest.common.enums.EnabledEnum;
import com.liam.autotest.sys.dao.ProjectMapper;
import com.liam.autotest.sys.pojo.domain.Project;
import com.liam.autotest.sys.pojo.dto.ProjectCreateDTO;
import com.liam.autotest.sys.pojo.dto.ProjectUpdateDTO;
import com.liam.autotest.sys.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public int insertProjcet(ProjectCreateDTO projectCreateDTO) {
        if (projectCreateDTO == null) {
            return 0;
        }

        Project project = createProjectByProjectCreateDTO(projectCreateDTO);

        return projectMapper.insert(project);
    }

    @Override
    public IPage<Project> getProjectPageList(Page<Project> page) {
        if (page == null) {
            return null;
        }
        return projectMapper.selectPage(page, Wrappers.lambdaQuery());
    }

    @Override
    public int deleteById(Long id) {
        if (id == null) {
            return 0;
        }
        LambdaUpdateWrapper<Project> projectUpdateWrapper = Wrappers.<Project>lambdaUpdate();
        projectUpdateWrapper.set(Project::getEnabled, EnabledEnum.DISABLE.getCode())
                .set(Project::getLastModifyTime, new Date())
                .set(Project::getLastModifyUserName, DefaultUser.userName)
                .set(Project::getLastModifyUserId, DefaultUser.userId)
                .eq(Project::getId, id);

        return projectMapper.update(null, projectUpdateWrapper);
    }

    @Override
    public int updateProject(ProjectUpdateDTO projectUpdateDTO) {
        if (projectUpdateDTO == null) {
            return 0;
        }

        Project project = createProjectByProjectUpdateDTO(projectUpdateDTO);

        return projectMapper.updateById(project);
    }


    private Project createProjectByProjectCreateDTO(ProjectCreateDTO projectCreateDTO) {
        Project project = Project.builder()
                .projectName(projectCreateDTO.getProjectName())
                .remark(projectCreateDTO.getRemark()).build();
        BasePropertyPOUtil.init(project, DefaultUser.userId, DefaultUser.userName);
        return project;
    }

    private Project createProjectByProjectUpdateDTO(ProjectUpdateDTO projectUpdateDTO) {
        Project project = Project.builder()
                .projectName(projectUpdateDTO.getProjectName())
                .remark(projectUpdateDTO.getRemark()).build();
        project.setId(projectUpdateDTO.getId());
        BasePropertyPOUtil.modify(project, DefaultUser.userId, DefaultUser.userName);
        return project;
    }

}
