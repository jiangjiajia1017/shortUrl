package com.jiang.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("records")
public class Record {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("long_url")
    private String longUrl;
    private String code;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
