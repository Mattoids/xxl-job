package com.xxl.job.executor.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName(value = "t_export_task")
public class ExportTask extends Model {
    public static final String COL_TYPE = "type";
    public static final String COL_SQL = "sql";
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字典
     */
    @TableField(value = "code")
    private String code;

    /**
     * 接收人邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 是否删除 0-正常 1-删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    /**
     * 创建时间
     */
    @TableField(value = "created")
    private LocalDateTime created;

    public static final String COL_ID = "id";

    public static final String COL_CODE = "code";

    public static final String COL_EMAIL = "email";

    public static final String COL_REMARK = "remark";

    public static final String COL_IS_DELETE = "is_delete";

    public static final String COL_CREATED = "created";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}