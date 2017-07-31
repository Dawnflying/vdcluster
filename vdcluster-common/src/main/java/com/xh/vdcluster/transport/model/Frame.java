package com.xh.vdcluster.transport.model;

import com.xh.vdcluster.common.ByteUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bloom on 2017/7/25.
 */
public class Frame implements Packet{

    private Header header;

    private Body body;

    public Frame(Header header,Body body){
        this.header = header;

    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public byte[] pack() {
        List<byte[]> list = new ArrayList<>();
        list.add(header.pack());
        list.add(body.pack());
        return ByteUtils.combineByteArray(list);
    }
}
