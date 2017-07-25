package com.xh.vdcluster.controller;

import com.xh.vdcluster.common.DetectServiceConfiguration;
import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.common.VdResultErrorCode;
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
    StreamService streamService;

    @Resource
    TokenService tokenService;

    @Resource
    VdService vdService;

    @RequestMapping("/register-stream")
    @Auth("register")
    public VdResult registerStream(@RequestParam(name = "token") String token, @RequestParam(name = "userId") String userId, @RequestBody List<Stream> streamList) {
        int code = tokenService.validate(token);

        if (VdResultErrorCode.ISFAILED(code))
            return new VdResult("ok", code, null, userId);

        List<DetectServiceConfiguration> configurationList = new ArrayList<>();

        return vdService.addServant(userId, token, configurationList);
    }

    @RequestMapping("/unregisterStream")
    @Auth("unregister")
    public VdResult unregisterStream(@RequestParam(name = "token") String token, @RequestParam(name = "userId") String userId, @RequestParam(name = "servantIds") List<String> servantIds) {

        int code = tokenService.validate(token);

        if (VdResultErrorCode.ISFAILED(code)) {


            return new VdResult("OK", VdResultErrorCode.AUTH_FAILED, null, userId);

        } else {


            return vdService.removeServant(userId, token, servantIds);
        }
    }

}
