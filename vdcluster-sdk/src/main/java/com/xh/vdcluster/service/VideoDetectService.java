package com.xh.vdcluster.service;

import com.xh.vdcluster.model.VideoDetectConfiguration;
import com.xh.vdcluster.model.VideoDetectResult;

/**
 * Created by bloom on 2017/7/21.
 */
public interface VideoDetectService {

    VideoDetectResult requestService(String username, String password);

    VideoDetectResult addService(String token, VideoDetectConfiguration configuration, Call);


}
