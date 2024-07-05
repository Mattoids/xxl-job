package com.xxl.job.executor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxl.job.executor.entity.ExportTask;
import com.xxl.job.executor.mapper.ExportTaskMapper;
import com.xxl.job.executor.service.ExportTaskService;
import org.springframework.stereotype.Service;

@Service
public class ExportTaskServiceImpl extends ServiceImpl<ExportTaskMapper, ExportTask> implements ExportTaskService {


    @Override
    public ExportTask queryOne(ExportTask params) {
        QueryWrapper<ExportTask> qw = new QueryWrapper<>();
        qw.eq("is_delete",0);
        qw.eq("code",params.getCode());
        return baseMapper.selectOne(qw);
    }

}
