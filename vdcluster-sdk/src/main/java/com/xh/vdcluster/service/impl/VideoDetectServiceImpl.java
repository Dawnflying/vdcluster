package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.common.VdConfiguration;
import com.xh.vdcluster.service.VideoDetectService;

/**
 * Created by macbookpro on 17/7/22.
 */
public class VideoDetectServiceImpl implements VideoDetectService {
    @Override
    public VdResult requestToken(String username, String password) {
        return null;
    }

    @Override
    public VdResult addService(String token, VdConfiguration configuration, Runnable handler) {



        return null;
    }

    @Override
    public VdResult stopService(String token, String serviceId) {
        return null;
    }

    @Override
    public VdResult removeService(String token, String serviceId) {
        return null;
    }
}
