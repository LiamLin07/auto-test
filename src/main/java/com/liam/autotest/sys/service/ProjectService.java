package com.liam.autotest.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liam.autotest.sys.pojo.domain.Project;
import com.liam.autotest.sys.pojo.dto.ProjectCreateDTO;
import com.liam.autotest.sys.pojo.dto.ProjectUpdateDTO;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
public interface ProjectService {
    /**
     * 添加项目
     *
     * @param projectCreateDTO
     * @return
     */
    int insertProjcet(ProjectCreateDTO projectCreateDTO);

    /**
     * 项目列表
     *
     * @param page
     * @return
     */
    IPage<Project> getProjectPageList(Page<Project> page);

    /**
     * 删除项目
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 更新项目
     *
     * @param projectUpdateDTO
     * @return
     */
    int updateProject(ProjectUpdateDTO projectUpdateDTO);


}
