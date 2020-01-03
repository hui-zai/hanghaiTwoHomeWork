package com.example.springbootcrudteam6luzhijian.pojo;

public class ResponseResult {
    private String msg;
    private String code;
    private Object object;

    public ResponseResult(String msg, String code, Object object) {
        this.msg = msg;
        this.code = code;
        this.object = object;
    }

    public ResponseResult() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
