package com.xxl.job.executor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxl.job.executor.entity.ExportTask;

public interface ExportTaskService extends IService<ExportTask> {
    ExportTask queryOne(ExportTask params);
}
