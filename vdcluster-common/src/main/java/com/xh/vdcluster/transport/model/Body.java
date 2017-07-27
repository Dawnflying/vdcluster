package com.xh.vdcluster.transport.model;

/**
 * Created by bloom on 2017/7/25.
 */
public class Body implements Packet<Body> {

    private int type;

    private int length;

    private String info;

    @Override
    public Body pack(byte[] data) {
        return null;
    }

    @Override
    public byte[] unpack(Body obj) {
        return new byte[0];
    }
}



