package com.xh.vdcluster.transport.model;

/**
 * Created by bloom on 2017/7/25.
 */
public interface Packet<T> {

    T pack(byte[] data);

    byte[] unpack(T obj);

}
