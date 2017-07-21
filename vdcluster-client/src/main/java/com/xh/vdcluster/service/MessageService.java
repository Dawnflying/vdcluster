package com.xh.vdcluster.service;

/**
 * Created by bloom on 2017/7/20.
 */
public interface MessageService<T> {
    void pushMessage(T msg) throws Exception;
}
