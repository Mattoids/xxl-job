package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.executor.entity.ExportTask;
import com.xxl.job.executor.entity.ExportTaskSql;
import com.xxl.job.executor.service.ExportTaskService;
import com.xxl.job.executor.service.ExportTaskSqlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class ExportTaskJob {

    private static Logger logger = LoggerFactory.getLogger(ExportTaskJob.class);

    @Autowired
    private ExportTaskService exportTaskService;

    @Autowired
    private ExportTaskSqlService exportTaskSqlService;

    @XxlJob("startHandler")
    public void startHandler() throws Exception {
        String command = XxlJobHelper.getJobParam();
        ExportTask exportTask = new ExportTask();
        exportTask.setCode(command);
        ExportTask task = exportTaskService.queryOne(exportTask);
        if (Objects.isNull(task)) {
            return;
        }

        ExportTaskSql taskSql = new ExportTaskSql();
        taskSql.setCode(task.getCode());
        taskSql.setTaskId(task.getId());
        List<ExportTaskSql> sqlList = exportTaskSqlService.query(taskSql);
        if (Objects.isNull(sqlList) || sqlList.size() == 0) {
            return;
        }

        sqlList.forEach(item -> {

        });
    }
}
