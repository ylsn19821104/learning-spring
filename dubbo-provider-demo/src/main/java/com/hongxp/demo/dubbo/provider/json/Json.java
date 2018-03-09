package com.hongxp.demo.dubbo.provider.json;


import com.hongxp.demo.dubbo.provider.page.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JiangBoCheng on 2017/7/26.
 * 200:Json.CODE_200
 * 200:Json.newInstance(result)
 * 200:Json.newInstance(result, page)
 * 400:Json.newInstance(errors)
 * 401:Json.CODE_401
 * 500:Json.CODE_500
 */

public class Json<T> {
    private int apistatus;
    private String msg;
    private T result;
    private Map<String, String> errors;

    /**
     * 构造方法
     *
     * @param apistatus
     */
    private Json(Apistatus apistatus) {
        this.apistatus = apistatus.getCode();
        this.msg = apistatus.getMsg();
    }

    /**
     * OK
     */
    public static Json<Object> CODE_200 = new Json<Object>(Apistatus.CODE_200);
    /**
     * Not Found
     */
    public static Json<Object> CODE_401 = new Json<Object>(Apistatus.CODE_401);
    /**
     * Internal Server Error
     */
    public static Json<Object> CODE_500 = new Json<Object>(Apistatus.CODE_500);

    /**
     * 返回非分页结果
     *
     * @param result
     * @param <T>
     * @return
     */
    public static <T> Json<T> newInstance(T result) {
        return new Json<T>(result);
    }

    /**
     * 返回分页结果
     *
     * @param result
     * @param page
     * @param <K>
     * @return
     */
    public static <K> Json<Map<String, Object>> newInstance(K result, Page page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageSize", page.getPageSize());
        map.put("page", page.getPage());
        map.put("total", page.getTotal());
        map.put("data", result);
        return new Json<Map<String, Object>>(map);
    }

    /**
     * 返回验证错误信息
     *
     * @param errors
     * @param extra
     * @param <T>
     * @return
     */
    public static <T> Json<T> newInstance(Map<String, String> errors, String extra) {
        return new Json<T>(errors, extra);
    }

    private Json(T result) {
        this.apistatus = Apistatus.CODE_200.getCode();
        this.msg = Apistatus.CODE_200.getMsg();
        this.result = result;
    }

    private Json(Map<String, String> errors, String extra) {
        this.apistatus = Apistatus.CODE_400.getCode();
        this.msg = Apistatus.CODE_400.getMsg() + " (" + extra + ")";
        this.errors = errors;
    }

    public int getApistatus() {
        return apistatus;
    }

    public String getMsg() {
        return msg;
    }

    public T getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}