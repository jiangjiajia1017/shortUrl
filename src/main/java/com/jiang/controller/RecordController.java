package com.jiang.controller;

import com.jiang.controller.utils.Result;
import com.jiang.pojo.Record;
import com.jiang.service.IRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class RecordController {

    @Autowired
    private IRecordService recordService;


    /**
     * 根据短域名编号 直接跳转到长域名
     *
     * @param code     短域名编号
     * @param response 301跳转
     */
    @GetMapping("{code}")
    public void index(@PathVariable String code, HttpServletResponse response) {
        Record record = recordService.getLongUrlByCode(code);
        //System.out.println(record);
        response.setStatus(301);
        response.setHeader("Location", record.getLongUrl());
    }

    /**
     * 根据长域名 生成短域名编号
     *
     * @param longUrl 长域名
     * @return json
     */
    @PostMapping()
    public Result add(@RequestParam(value = "longUrl", required = true) String longUrl) {
        Record record = recordService.getCodeByLongUrl(longUrl);
        return Result.success(record.getCode());
    }

}
