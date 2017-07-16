package com.xh.videodetect.model;

import java.util.Date;

/**
 * Created by bloom on 2017/7/16.
 */
public class Consumer extends Entity{

    private String name;

    private String token;

    private String ipAddress;

    private int port;

    private int privilegeLevel;

    private Date expiredTime;

    private StreamModel[] models;

    private int totalTimeCount;
}
