package com.jiang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jiang.pojo.Record;

public interface IRecordService extends IService<Record> {
    public Record getCodeByLongUrl(String longUrl);
    public Record getLongUrlByCode(String code);
    public String getAvailableCode();
}
