package com.xh.vdcluster.common;

import java.io.Serializable;

/**
 * Created by bloom on 2017/7/16.
 */
public class VdResult implements Serializable {


    private String state;
    private int code;
    private Object data;
    private String requestId;


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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public VdResult(String state, int code, Object data, String requestId) {
        this.state = state;
        this.code = code;
        this.data = data;
        this.requestId = requestId;
    }
}
