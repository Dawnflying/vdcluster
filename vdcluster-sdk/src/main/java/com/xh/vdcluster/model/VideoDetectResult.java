package com.xh.vdcluster.model;

/**
 * Created by bloom on 2017/7/21.
 */
public class VideoDetectResult {


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
}
