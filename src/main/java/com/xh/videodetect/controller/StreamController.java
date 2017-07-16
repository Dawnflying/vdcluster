package com.xh.videodetect.controller;

import com.xh.videodetect.model.VdResult;
import com.xh.videodetect.service.StreamService;
import com.xh.videodetect.service.TokenService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by bloom on 2017/7/16.
 */
@RestController
public class StreamController {

    @Resource
    StreamService streamService;

    @Resource
    TokenService tokenService;

    @RequestMapping("/registerStream")
    public VdResult registerStream(@RequestParam(name = "token") String token) {

        return null;
    }

    @RequestMapping("/registerStreamGroup")
    public VdResult registerStreamGroup(@RequestParam(name = "token") String token @RequestBody ) {

        return null;
    }

    @RequestMapping("/unregisterStream")
    public VdResult unregisterStream(@RequestParam(name = "token") String token, @RequestParam(name = "userId") String userId, @RequestParam(name = "streamId") String streamId) {

        boolean bValid = tokenService.validate(userId, token);

        if (!bValid) {
            return new VdResult("OK",VdResult.AUTH_FAILED,null);
        } else {
            return new VdResult("OK",VdResult.AUTH_SUCCESS,null);
        }

    }

    @RequestMapping("/unregisterStreamGroup")
    public VdResult unregisterStreamGroup(@RequestParam(name = "token") String token, @RequestParam(name = "userId") String userId) {

        boolean bValid = tokenService.validate(userId, token);

        if (!bValid) {
            return new VdResult("OK", VdResult.AUTH_FAILED, null);

        } else {
            return new VdResult("OK", VdResult.AUTH_SUCCESS, null);
        }

    }


}
