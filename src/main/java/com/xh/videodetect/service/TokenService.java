package com.xh.videodetect.service;

/**
 * Created by bloom on 2017/7/16.
 */
public interface TokenService {
    boolean validate(String userId, String token);
}
