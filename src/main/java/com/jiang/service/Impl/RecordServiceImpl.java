package com.jiang.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiang.controller.utils.Utils;
import com.jiang.mapper.RecordMapper;
import com.jiang.pojo.Record;
import com.jiang.service.IRecordService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {

    @Autowired
    private RecordMapper recordMapper;

    /**
     * 根据长域名生成短域名编号，如已存在则直接返回短域名编号
     * @param longUrl 长域名
     * @return Record
     */
    public Record getCodeByLongUrl(String longUrl) {
        LambdaQueryWrapper<Record> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Strings.isNotEmpty(longUrl), Record::getLongUrl, longUrl);
        Record record = recordMapper.selectOne(queryWrapper);
        //当没有查询到数据时需新增一条记录
        if (record == null) {
            Record recordNew = new Record();
            recordNew.setLongUrl(longUrl);
            recordNew.setCode(getAvailableCode());
            recordMapper.insert(recordNew);
            return recordNew;
        } else {
            return record;
        }
    }

    /**
     * 根据短域名编号 查找记录
     * @param code 短域名编号
     * @return Record
     */
    public Record getLongUrlByCode(String code) {
        LambdaQueryWrapper<Record> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Strings.isNotEmpty(code), Record::getCode, code);
        return recordMapper.selectOne(queryWrapper);
    }

    /**
     * 获取可用的随机数
     * @return randomString
     */
    public String getAvailableCode() {
        boolean $flag = true;
        String randomString = "";
        do {
            randomString = Utils.getRandomString(6);
            LambdaQueryWrapper<Record> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Strings.isNotEmpty(randomString), Record::getCode, randomString);
            Record record = this.getOne(queryWrapper);
            System.out.println(record);
            if (record == null) {
                $flag = false;
            }
        } while ($flag);
        return randomString;
    }


}
