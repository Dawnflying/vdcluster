package com.xh.vdcluster.controller;

import com.xh.vdcluster.common.*;
import com.xh.vdcluster.common.annotation.Auth;
import com.xh.vdcluster.repository.model.Stream;
import com.xh.vdcluster.service.StreamService;
import com.xh.vdcluster.service.TokenService;
import com.xh.vdcluster.service.VdService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bloom on 2017/7/16.
 */
@RestController
public class StreamController {

    @Resource
    TokenService tokenService;

    @Resource
    VdService vdService;

    @RequestMapping("/register-stream")
    @Auth("register")
    public VdResult registerStream(@RequestParam(name = "token") String token, @RequestParam(name = "userId") String userId, @RequestBody List<String> streamList) {
        int code = tokenService.validate(userId, token);

        if (VdResultErrorCode.ISFAILED(code))
            return new VdResult("token error", code, null, userId);

        List<DetectServiceConfiguration> configurationList = new ArrayList<>();

        for(String url: streamList){
            List<DetectType> detectTypes = new ArrayList<>();
            detectTypes.add(new DetectType("smoke", 0.9));
            DetectServiceConfiguration configuration = new DetectServiceConfiguration();
            configuration.setDetectType(detectTypes);
            configuration.setStreamType(0);
            configuration.setDecodeMode(0);
            configuration.setServiceId(Md5Utils.MD5(url));
            configuration.setFrameHeight(300);
            configuration.setFrameWidth(400);
            configuration.setStreamURL(url);
            configurationList.add(configuration);
        }

        return vdService.addServant(userId, token, configurationList);
    }

    @RequestMapping("/unregisterStream")
    @Auth("unregister")
    public VdResult unregisterStream(@RequestParam(name = "token") String token, @RequestParam(name = "userId") String userId, @RequestParam(name = "servantIds") List<String> servantIds) {

        int code = tokenService.validate(userId, token);

        if (VdResultErrorCode.ISFAILED(code)) {


            return new VdResult("OK", VdResultErrorCode.AUTH_FAILED, null, userId);

        } else {


            return vdService.removeServant(userId, token, servantIds);
        }
    }

}
