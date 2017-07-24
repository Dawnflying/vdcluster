package com.xh.vdcluster.vdmanager.beans;

/**
 * Created by bloom on 2017/7/16.
 */
public class StreamModel {

    public enum STREAMSTATE{
        IDLE,
        RUNNING,
    }

    private String name;

    private String uri;

    private String protocol;

    private String ipAddress;

    private int port;

    private int timeCount;

    private STREAMSTATE streamState;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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

    public int getTimeCount() {
        return timeCount;
    }

    public void setTimeCount(int timeCount) {
        this.timeCount = timeCount;
    }

    public STREAMSTATE getStreamState() {
        return streamState;
    }

    public void setStreamState(STREAMSTATE streamState) {
        this.streamState = streamState;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public StreamModel(String name, String ipAddress, int port, String uri){
        super();
        this.name = name;
        this.ipAddress = ipAddress;
        this.port = port;
        this.uri = uri;

    }
}
