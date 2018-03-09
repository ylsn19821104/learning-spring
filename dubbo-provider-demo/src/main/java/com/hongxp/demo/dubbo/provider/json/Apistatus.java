package com.hongxp.demo.dubbo.provider.json;

/**
 * json响应中的meta头
 */
public class Apistatus {
    public static final Apistatus CODE_200 = new Apistatus(200, "OK");
    public static final Apistatus CODE_400 = new Apistatus(400, "Bad Request");
    public static final Apistatus CODE_401 = new Apistatus(401, "No Permission");
    public static final Apistatus CODE_500 = new Apistatus(500, "Internal Server Error");

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态信息
     */
    private String msg;

    public Apistatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}