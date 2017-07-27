package com.xh.vdcluster.rpc;

import org.apache.thrift.async.AsyncMethodCallback;

/**
 * Created by bloom on 2017/7/26.
 */
public interface ServiceAdapter {
    void init(String host, int port, DetectService.Iface service,AsyncMethodCallback<Void> callback);
}
