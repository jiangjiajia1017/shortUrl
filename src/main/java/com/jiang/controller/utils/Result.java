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
     * 返回成功
     */
    public static Result success(List<Object> data, long count) {
        Result result = new Result();
        result.setCode(0);//成功
        result.setMsg("成功");//提示语
        result.setData(data);
        return result;
    }

    /**
     * 返回成功
     */
    public static Result success(List<Object> data) {
        Result result = new Result();
        result.setCode(0);//成功
        result.setMsg("成功");//提示语
        result.setData(data);
        return result;
    }

    /**
     * 返回成功
     */
    public static Result successForPage(List<Object> data, Integer count) {
        Result result = new Result();
        result.setCode(0);//成功
        result.setMsg("成功");//提示语
        result.setData(data);
        return result;
    }

    /**
     * 返回成功
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(0);//成功
        result.setMsg("成功");//提示语
        return result;
    }

    /**
     * 返回成功
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);//成功
        result.setMsg("成功");//提示语
        result.setData(object);//返回内容
        return result;
    }

    /**
     * 返回失败
     */
    public static Result error() {
        Result result = new Result();
        result.setCode(1);//失败
        result.setMsg("失败");//提示语
        return result;
    }

    /**
     * 返回失败
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(1);//失败
        result.setMsg(msg);//提示语
        return result;
    }

    /**
     * 返回失败
     */
    public static Result error(int code, String msg) {
        Result result = new Result();
        result.setCode(code);//失败
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
