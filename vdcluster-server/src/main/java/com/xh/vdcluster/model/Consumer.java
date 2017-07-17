package com.xh.vdcluster.model;

import com.xh.vdcluster.authenication.Token;

import java.util.Date;

/**
 * Created by bloom on 2017/7/16.
 */
public class Consumer extends Entity{

    private int id;

    private String name;

    private Token access_token;

    private String ipAddress;

    private int port;

    private int privilegeLevel;

    private Date expiredTime;

    private StreamModel[] models;

    private int totalTimeCount;
}
