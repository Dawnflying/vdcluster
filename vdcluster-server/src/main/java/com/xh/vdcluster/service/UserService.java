package com.xh.vdcluster.service;

/**
 * Created by bloom on 2017/7/16.
 */
public interface UserService {

    boolean authenticate(String name,String code);
}
