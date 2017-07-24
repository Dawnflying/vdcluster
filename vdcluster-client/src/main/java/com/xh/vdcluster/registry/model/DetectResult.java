package com.xh.vdcluster.registry.model;

import java.util.Date;

/**
 * Created by bloom on 2017/7/18.
 */
public class DetectResult extends Entity{

    /**
     * 识别服务请求id
     */
    private Integer requestId;

    /**
     * 识别命中时间
     */
    private Date hitTime;

    /**
     * 识别命中类型
     */
    private int hitType;

    /**
     * 置信指数
     */
    private double confidenceThreshold;

    /**
     * 识别框位置
     */
    private double rectX;

    /**
     * 识别框类型
     */
    private double rectY;

    /**
     * 识别框高度
     */
    private double height;

    /**
     * 识别框宽度
     */
    private double width;

    /**
     * 识别命中预览照片
     */
    private String[] previewPictures;

    /**
     * 识别视频片段
     */
    private String videoURL;
}
