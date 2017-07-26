package com.xh.vdcluster.transport.model;

/**
 * Created by bloom on 2017/7/25.
 */
public class Frame implements Packet<Frame>{

    private Header header;

    private Body body;


    @Override
    public Frame pack(byte[] data) {
        return null;
    }

    @Override
    public byte[] unpack(Frame obj) {
        return new byte[0];
    }
}
