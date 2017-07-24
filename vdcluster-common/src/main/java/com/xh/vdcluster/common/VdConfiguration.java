package com.xh.vdcluster.common;

import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TType;

import java.util.List;
import java.util.Map;

/**
 * Created by bloom on 2017/7/21.
 */
public class VdConfiguration {

    private String serviceId;

    private String streamURL;

    private Integer streamType;

    private Integer decodeMode;

    private double frameWidth;

    private double frameHeight;

    private Map<Integer, Double> detectSensitivity;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getStreamURL() {
        return streamURL;
    }

    public void setStreamURL(String streamURL) {
        this.streamURL = streamURL;
    }

    public Integer getStreamType() {
        return streamType;
    }

    public void setStreamType(Integer streamType) {
        this.streamType = streamType;
    }

    public Integer getDecodeMode() {
        return decodeMode;
    }

    public void setDecodeMode(Integer decodeMode) {
        this.decodeMode = decodeMode;
    }

    public double getFrameWidth() {
        return frameWidth;
    }

    public void setFrameWidth(double frameWidth) {
        this.frameWidth = frameWidth;
    }

    public double getFrameHeight() {
        return frameHeight;
    }

    public void setFrameHeight(double frameHeight) {
        this.frameHeight = frameHeight;
    }

    public Map<Integer, Double> getDetectSensitivity() {
        return detectSensitivity;
    }

    public void setDetectSensitivity(Map<Integer, Double> detectSensitivity) {
        this.detectSensitivity = detectSensitivity;
    }
}
