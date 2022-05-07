package com.jiang.controller.utils;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Data
public class Result {
    private int code;//返回码
    private Object data;//返回码
    private String msg;//返回描述


    /**
     * 返回success
     */
    public static Result success(List<Object> data, long count) {
        Result result = new Result();
        result.setCode(0);//success
        result.setMsg("success");//提示语
        result.setData(data);
        return result;
    }

    /**
     * 返回success
     */
    public static Result success(List<Object> data) {
        Result result = new Result();
        result.setCode(0);//success
        result.setMsg("success");//提示语
        result.setData(data);
        return result;
    }

    /**
     * 返回success
     */
    public static Result successForPage(List<Object> data, Integer count) {
        Result result = new Result();
        result.setCode(0);//success
        result.setMsg("success");//提示语
        result.setData(data);
        return result;
    }

    /**
     * 返回success
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(0);//success
        result.setMsg("success");//提示语
        return result;
    }

    /**
     * 返回success
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);//success
        result.setMsg("success");//提示语
        result.setData(object);//返回内容
        return result;
    }

    /**
     * 返回failed
     */
    public static Result error() {
        Result result = new Result();
        result.setCode(1);//failed
        result.setMsg("failed");//提示语
        return result;
    }

    /**
     * 返回failed
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(1);//failed
        result.setMsg(msg);//提示语
        return result;
    }

    /**
     * 返回failed
     */
    public static Result error(int code, String msg) {
        Result result = new Result();
        result.setCode(code);//failed
        result.setMsg(msg);//提示语
        return result;
    }

    /**
     * 返回信息
     */
    public static Result response(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * Response输出Json格式
     */
    public static void responseJson(ServletResponse response, Object data) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(data));
            out.flush();
        } catch (Exception e) {
            System.out.println("Response输出Json异常：" + e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
