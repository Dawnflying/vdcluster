package com.xh.vdcluster.transport.model;

/**
 * Created by bloom on 2017/7/25.
 */
public class Header implements Packet<Header> {

    private int frameId;

    private byte version;

    private byte nodeId;

    private byte managerId;

    private byte headerLength;


    @Override
    public Header pack(byte[] data) {
        return null;
    }

    @Override
    public byte[] unpack(Header obj) {
        return new byte[0];
    }
}
