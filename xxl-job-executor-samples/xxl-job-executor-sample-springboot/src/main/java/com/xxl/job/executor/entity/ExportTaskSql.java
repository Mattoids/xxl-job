package com.xxl.job.executor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "t_export_task_sql")
public class ExportTaskSql extends Model {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字典
     */
    @TableField(value = "code")
    private String code;

    /**
     * 任务ID
     */
    @TableField(value = "task_id")
    private Integer taskId;

    /**
     * 导出类型 xslx xls csv
     */
    @TableField(value = "`type`")
    private String type;

    /**
     * 数据源
     */
    @TableField(value = "`source`")
    private String source;

    /**
     * 导出语句
     */
    @TableField(value = "`sql`")
    private String sql;

    /**
     * 是否删除 0-正常 1-删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    @TableField(value = "created")
    private LocalDateTime created;

    public static final String COL_ID = "id";

    public static final String COL_CODE = "code";

    public static final String COL_TASK_ID = "task_id";

    public static final String COL_TYPE = "type";

    public static final String COL_SOURCE = "source";

    public static final String COL_SQL = "sql";

    public static final String COL_IS_DELETE = "is_delete";

    public static final String COL_CREATED = "created";
}