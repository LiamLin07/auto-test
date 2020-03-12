package com.liam.autotest.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liam.autotest.common.base.page.DefaultPageForm;
import com.liam.autotest.common.base.page.PageUtil;
import com.liam.autotest.common.base.page.PageVO;
import com.liam.autotest.common.enums.ResultEnum;
import com.liam.autotest.common.enums.ValidationEnum;
import com.liam.autotest.common.exception.ValidationException;
import com.liam.autotest.common.result.ResultVO;
import com.liam.autotest.common.result.ResultVOUtil;
import com.liam.autotest.sys.pojo.domain.Project;
import com.liam.autotest.sys.pojo.dto.ProjectCreateDTO;
import com.liam.autotest.sys.pojo.dto.ProjectUpdateDTO;
import com.liam.autotest.sys.pojo.form.ProjectDeleteForm;
import com.liam.autotest.sys.pojo.form.ProjectUpdateForm;
import com.liam.autotest.sys.pojo.form.ProjectAddForm;
import com.liam.autotest.sys.pojo.vo.ProjectListVO;
import com.liam.autotest.sys.service.IteratorValidationService;
import com.liam.autotest.sys.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Liam
 * @Date 2020/3/8
 */
@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IteratorValidationService iteratorValidationService;

    @PostMapping("/add")
    public ResultVO<Integer> addProject(@Valid @RequestBody ProjectAddForm projectAddForm) {
        log.info("Start add project! param = {}", projectAddForm);

        ProjectCreateDTO projectCreateDTO = createProjectCreateDTOByProjectAddForm(projectAddForm);
        int insertNum = projectService.insertProjcet(projectCreateDTO);

        log.info("End add project! insertNum = {}", insertNum);
        return ResultVOUtil.successOrFailed(insertNum > 0, ResultEnum.INSERT_FAILED);
    }

    @PostMapping("/delete")
    public ResultVO<Integer> deleteProject(@Valid @RequestBody ProjectDeleteForm projectDeleteForm) {

        log.info("Start delete project! param = {}", projectDeleteForm);

        validProjectIdUseage(projectDeleteForm.getId());

        int deleteNum = projectService.deleteById(projectDeleteForm.getId());

        log.info("End delete project! deleteNum = {}", deleteNum);
        return ResultVOUtil.successOrFailed(deleteNum > 0, ResultEnum.DELETE_FAILED);
    }

    @PostMapping("/update")
    public ResultVO<Integer> updateProject(@Valid @RequestBody ProjectUpdateForm projectUpdateForm) {

        log.info("Start update project! param = {}", projectUpdateForm);

        ProjectUpdateDTO projectUpdateDTO = createProjectUpdateDTOByProjectUpdateForm(projectUpdateForm);
        int updateNum = projectService.updateProject(projectUpdateDTO);

        log.info("End update project! updateNum = {}", updateNum);
        return ResultVOUtil.successOrFailed(updateNum > 0, ResultEnum.UPDATE_FAILED);
    }

    @PostMapping("/list")
    public ResultVO<PageVO<ProjectListVO>> listProject(@RequestBody DefaultPageForm defaultPageForm) {
        log.info("Start list project! param = {}", defaultPageForm);
        Page<Project> page = PageUtil.getPage(defaultPageForm);

        IPage<Project> projectPageList = projectService.getProjectPageList(page);

        List<ProjectListVO> projectListVOS = createProjectListVOSByProjectList(projectPageList.getRecords());

        log.info("End list project!");
        return ResultVOUtil.success(PageUtil.getPageVO(projectPageList.getTotal(), projectListVOS));
    }

    private void validProjectIdUseage(Long id) {
        if (iteratorValidationService.isProjectIdRelateByIterator(id)) {
            throw new ValidationException(ValidationEnum.PROJECT_ID_RELATED_BY_ITERATOR);
        }
    }

    private List<ProjectListVO> createProjectListVOSByProjectList(List<Project> projectList) {
        if (!CollectionUtils.isEmpty(projectList)) {
            return projectList.stream().map(project -> {
                ProjectListVO projectListVO = new ProjectListVO();
                BeanUtils.copyProperties(project, projectListVO);
                return projectListVO;
            }).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    private ProjectCreateDTO createProjectCreateDTOByProjectAddForm(ProjectAddForm projectAddForm) {
        return ProjectCreateDTO.builder()
                .projectName(projectAddForm.getProjectName())
                .remark(projectAddForm.getRemark())
                .build();
    }

    private ProjectUpdateDTO createProjectUpdateDTOByProjectUpdateForm(ProjectUpdateForm projectUpdateForm) {
        return ProjectUpdateDTO.builder()
                .id(projectUpdateForm.getId())
                .projectName(projectUpdateForm.getProjectName())
                .remark(projectUpdateForm.getRemark()).build();
    }

}
