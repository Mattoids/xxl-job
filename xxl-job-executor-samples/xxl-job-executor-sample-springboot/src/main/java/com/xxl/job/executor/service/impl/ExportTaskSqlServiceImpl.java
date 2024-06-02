package com.xxl.job.executor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxl.job.executor.entity.ExportTaskSql;
import com.xxl.job.executor.mapper.ExportTaskSqlMapper;
import com.xxl.job.executor.service.ExportTaskSqlService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportTaskSqlServiceImpl extends ServiceImpl<ExportTaskSqlMapper, ExportTaskSql> implements ExportTaskSqlService {

    @Override
    public List<ExportTaskSql> query(ExportTaskSql params) {
        QueryWrapper<ExportTaskSql> qw = new QueryWrapper<>();
        qw.eq("is_delete",0);
        qw.eq("code",params.getCode());
        qw.eq("task_id",params.getTaskId());
        return baseMapper.selectList(qw);
    }
}
