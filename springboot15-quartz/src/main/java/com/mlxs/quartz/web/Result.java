package com.mlxs.quartz.web;


/**
 * Result类描述:
 *
 * @author yangzhenlong
 * @since 2018/1/22
 */
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public static <T> Result success(T obj){
        Result result = new Result();
        result.setCode("0");
        result.setMsg("success");
        result.setData(obj);
        return result;
    }

    public static <T> Result error(String code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
