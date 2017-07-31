package com.xh.vdcluster.transport.model;

import com.xh.vdcluster.common.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bloom on 2017/7/25.
 */
public class Body implements Packet {

    private static Logger logger = LoggerFactory.getLogger(Body.class);

    private int type;

    private int length;

    private String info;

    private byte[] data;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public byte[] pack() {

        try {
            List<byte[]> list = new ArrayList<>();
            list.add(ByteUtils.intToByteArray(type));
            list.add(ByteUtils.intToByteArray(length));
            list.add(info.getBytes("utf-8"));
            return ByteUtils.combineByteArray(list);

        } catch (Exception e) {
            logger.info("pack error:type:{},length:{},info:{}", type, length, info);
        }

        return null;
    }
}



