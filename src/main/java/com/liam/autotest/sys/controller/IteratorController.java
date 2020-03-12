package com.liam.autotest.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liam.autotest.common.base.page.DefaultPageForm;
import com.liam.autotest.common.base.page.PageUtil;
import com.liam.autotest.common.base.page.PageVO;
import com.liam.autotest.common.enums.ResultEnum;
import com.liam.autotest.common.result.ResultVO;
import com.liam.autotest.common.result.ResultVOUtil;
import com.liam.autotest.sys.pojo.domain.Iterator;
import com.liam.autotest.sys.pojo.form.IteratorAddForm;
import com.liam.autotest.sys.pojo.form.IteratorDeleteForm;
import com.liam.autotest.sys.pojo.form.IteratorUpdateForm;
import com.liam.autotest.sys.pojo.vo.IteratorListVO;
import com.liam.autotest.sys.service.IteratorService;
import com.liam.autotest.sys.service.ProjectValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author Liam
 * @Date 2020/3/9
 */
@Slf4j
@RestController
@RequestMapping("/iterator")
public class IteratorController {

    @Autowired
    private IteratorService iteratorService;

    @Autowired
    private ProjectValidationService projectValidationService;

    @PostMapping("/add")
    public ResultVO<String> addIterator(@Valid @RequestBody IteratorAddForm iteratorAddForm) {
        log.info("Start add iterator! param = {}", iteratorAddForm);

        // 校验项目id
        projectValidationService.validProjectId(iteratorAddForm.getProjectId());

        int insertNum = iteratorService.addIterator(iteratorAddForm.getIteratorName(), iteratorAddForm.getProjectId(), iteratorAddForm.getRemark());

        log.info("End add iterator! insertNum = {}", insertNum);
        return ResultVOUtil.successOrFailed(insertNum > 0, ResultEnum.INSERT_FAILED);
    }

    @PostMapping("/delete")
    public ResultVO<String> deleteIterator(@Valid @RequestBody IteratorDeleteForm iteratorDeleteForm) {
        log.info("Start delete iterator! param = {}", iteratorDeleteForm);
        int deleteNum = iteratorService.deleteIteratorById(iteratorDeleteForm.getIteratorId());
        log.info("End delete iterator! deleteNum = {}", deleteNum);
        return ResultVOUtil.successOrFailed(deleteNum > 0, ResultEnum.DELETE_FAILED);
    }

    @PostMapping("/update")
    public ResultVO<String> updateIterator(@Valid @RequestBody IteratorUpdateForm iteratorUpdateForm) {
        log.info("Start update iterator! param = {}", iteratorUpdateForm);
        int updateNum = iteratorService.updateIteratorById(iteratorUpdateForm.getId(), iteratorUpdateForm.getIteratorName(), iteratorUpdateForm.getProjectId(), iteratorUpdateForm.getRemark());
        log.info("End update iterator! param = {}", updateNum);
        return ResultVOUtil.successOrFailed(updateNum > 0, ResultEnum.UPDATE_FAILED);
    }

    @PostMapping("/list")
    public ResultVO<PageVO<IteratorListVO>> listIterator(@RequestBody DefaultPageForm defaultPageForm) {
        Page<Iterator> page = PageUtil.getPage(defaultPageForm);

        log.info("Start list iterator! param = {}", defaultPageForm);
        IPage<IteratorListVO> iteratorListVOIPage = iteratorService.selectIteratorVOByPage(page);
        PageVO<IteratorListVO> pageVO = PageUtil.getPageVO(iteratorListVOIPage);
        log.info("End list iterator!");

        return ResultVOUtil.success(pageVO);
    }
}
