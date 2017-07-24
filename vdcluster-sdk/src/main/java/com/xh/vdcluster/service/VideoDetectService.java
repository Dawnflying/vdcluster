package com.xh.vdcluster.service;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.VdResult;

/**
 * Created by bloom on 2017/7/21.
 */
public interface VideoDetectService {

    VdResult requestToken(String username, String password);

    VdResult addService(String token, DetectServiceConfiguration configuration, Runnable handler);

    VdResult stopService(String token, String serviceId);

    VdResult removeService(String token, String serviceId);
}
