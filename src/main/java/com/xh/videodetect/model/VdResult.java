package com.xh.videodetect.model;

import java.io.Serializable;

/**
 * Created by bloom on 2017/7/16.
 */
public class VdResult implements Serializable {


    public static final int AUTH_NONE = 0;
    public static final int AUTH_SUCCESS = 1;
    public static final int AUTH_FAILED = -1;

    private String state;
    private int code;
    private Object data;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public VdResult(String state, int code, Object data) {
        this.state = state;
        this.code = code;
        this.data = data;
    }
}
