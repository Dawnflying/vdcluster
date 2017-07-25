package com.xh.vdcluster.service;

import com.xh.vdcluster.common.VdResultErrorCode;

/**
 * Created by bloom on 2017/7/16.
 */
public interface TokenService {

    int validate(String token);
}
