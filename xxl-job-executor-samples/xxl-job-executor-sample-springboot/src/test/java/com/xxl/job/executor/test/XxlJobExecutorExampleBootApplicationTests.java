package com.xxl.job.executor.test;

import cn.hutool.json.JSONUtil;
import com.xxl.job.executor.entity.ExportTask;
import com.xxl.job.executor.service.ExportTaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class XxlJobExecutorExampleBootApplicationTests {

	@Autowired
	private ExportTaskService exportTaskService;

	@Test
	public void test() {
		System.out.println("--------------------");
		ExportTask task = new ExportTask();
		task.setCode("test");
		ExportTask result = exportTaskService.queryOne(task);
		System.out.println(JSONUtil.toJsonPrettyStr(result));
	}

}