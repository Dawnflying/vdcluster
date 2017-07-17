package com.xh.vdcluster.model;

/**
 * Created by bloom on 2017/7/16.
 */
public class Node extends Entity{

    private String name;

    private String ipAddress;

    private int port;

    private StreamModel[] models;

    private int weight;

    private int capbility;

}
