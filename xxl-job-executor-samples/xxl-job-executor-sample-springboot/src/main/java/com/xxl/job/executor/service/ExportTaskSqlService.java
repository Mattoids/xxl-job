package com.xxl.job.executor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxl.job.executor.entity.ExportTaskSql;

import java.util.List;

public interface ExportTaskSqlService extends IService<ExportTaskSql> {

    List<ExportTaskSql> query(ExportTaskSql params);
}
