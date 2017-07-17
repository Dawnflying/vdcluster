package com.xh.vdcluster.rpc;

import java.io.Serializable;

/**
 * Created by bloom on 2017/7/13.
 */
public class Result implements Serializable {

    private static final long serialVersionUID = -3135030969999063172L;

    private Object data;

    public Result(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
