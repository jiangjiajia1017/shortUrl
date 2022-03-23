package com.jiang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("records")
public class Record {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("long_url")
    private String longUrl;
    private String code;
}
