package com.hongxp.demo.dubbo.provider.common;


/**
 * Created by liuqingzhi on 2018/01/30.
 * 表示给调用者返回的结果，此结果要表示调用是否成功、返回的消息、数据。
 */
public class InfoDTO<T>  {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 给调用者的消息
     */
    private String msg;
    /**
     * 给调用者的数据
     */
    private T data;
    public InfoDTO() {
        super();
    }
    public InfoDTO(boolean success, String msg) {
        super();
        this.success = success;
        this.msg = msg;
    }
    public boolean isSuccess() {
        return success;
    }
    public InfoDTO<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }
    public String getMsg() {
        return msg;
    }
    public InfoDTO<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }
    public T getData() {
        return data;
    }
    public InfoDTO<T> setData(T data) {
        this.data = data;
        return this;
    }
}
