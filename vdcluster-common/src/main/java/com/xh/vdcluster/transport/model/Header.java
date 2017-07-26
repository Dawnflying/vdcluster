package com.xh.vdcluster.transport.model;

/**
 * Created by bloom on 2017/7/25.
 */
public class Header implements Packet<Header> {
    @Override
    public Header pack(byte[] data) {
        return null;
    }

    @Override
    public byte[] unpack(Header obj) {
        return new byte[0];
    }
}
