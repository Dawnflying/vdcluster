package com.xh.vdcluster.registry.model;

import com.xh.vdcluster.common.Entity;
import com.xh.vdcluster.repository.model.Stream;

import java.util.List;

/**
 * Created by bloom on 2017/7/16.
 */
public class Node extends Entity {


    private String nodeId;

    private String name;

    private String ipAddress;

    private int port;

    private List<Stream> streamList;

    private int weight;

    private int capability;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<Stream> getStreamList() {
        return streamList;
    }

    public void setStreamList(List<Stream> streamList) {
        this.streamList = streamList;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCapability() {
        return capability;
    }

    public void setCapability(int capbility) {
        this.capability = capbility;
    }
}
