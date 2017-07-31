package com.xh.vdcluster.transport.model;

import com.xh.vdcluster.common.ByteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bloom on 2017/7/25.
 */
public class Header implements Packet {

    private static Logger logger = LoggerFactory.getLogger(Header.class);

    private int frameId;

    private byte version;

    private byte nodeId;

    private byte managerId;

    private byte headerLength;

    public int getFrameId() {
        return frameId;
    }

    public void setFrameId(int frameId) {
        this.frameId = frameId;
    }

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public byte getNodeId() {
        return nodeId;
    }

    public void setNodeId(byte nodeId) {
        this.nodeId = nodeId;
    }

    public byte getManagerId() {
        return managerId;
    }

    public void setManagerId(byte managerId) {
        this.managerId = managerId;
    }

    public byte getHeaderLength() {
        return headerLength;
    }

    public void setHeaderLength(byte headerLength) {
        this.headerLength = headerLength;
    }

    @Override
    public byte[] pack() {
        try {
            List<byte[]> list = new ArrayList<>();
            list.add(ByteUtils.intToByteArray(frameId));
            list.add(new byte[]{version, nodeId, managerId, headerLength});
            return ByteUtils.combineByteArray(list);

        } catch (Exception e) {
            logger.info("header pack error:frameId:{},version:{},nodeId:{},managerId:{},headerLength:{}", frameId, version, nodeId, managerId, headerLength);
        }

        return null;
    }
}
