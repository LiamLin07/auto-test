package com.liam.autotest.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liam.autotest.sys.pojo.domain.Iterator;
import com.liam.autotest.sys.pojo.vo.IteratorListVO;

public interface IteratorMapper extends BaseMapper<Iterator> {
    /**
     * 分页查询迭代数据
     *
     * @param page
     * @return
     */
    IPage<IteratorListVO> selectByIteratorListByPage(Page<Iterator> page);
}