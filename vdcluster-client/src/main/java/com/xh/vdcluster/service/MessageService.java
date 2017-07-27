package com.xh.vdcluster.service;

import javax.security.auth.callback.Callback;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by bloom on 2017/7/20.
 */
public interface MessageService {

    void pushMessage(String topic, Object msg) throws Exception;

    void subscribe(String topic, final Callable<Object> callable) throws Exception;
}
