package com.xh.vdcluster.controller;

import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.common.annotation.Auth;
import com.xh.vdcluster.repository.model.Stream;
import com.xh.vdcluster.service.StreamService;
import com.xh.vdcluster.service.TokenService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @RequestMapping("/registerStream")
    @Auth("register")
    public VdResult registerStream(@RequestParam(name = "token") String token, @RequestBody Stream streamModel) {

        return null;
    }

    @RequestMapping("/registerStreamGroup")
    @Auth("register")
    public VdResult registerStreamGroup(@RequestParam(name = "token") String token, @RequestBody List<Stream> streamModelList
                                        ) {

        return null;
    }

    @RequestMapping("/unregisterStream")
    @Auth("unregister")
    public VdResult unregisterStream(@RequestParam(name = "token") String token, @RequestParam(name = "userId") String userId, @RequestParam(name = "streamId") String streamId) {

        boolean bValid = tokenService.validate(userId, token);

        if (!bValid) {
            return new VdResult("OK",VdResult.AUTH_FAILED,null);
        } else {
            return new VdResult("OK",VdResult.AUTH_SUCCESS,null);
        }

    }

    @RequestMapping("/unregisterStreamGroup")
    @Auth("unregister")
    public VdResult unregisterStreamGroup(@RequestParam(name = "token") String token, @RequestParam(name = "userId") String userId) {

        boolean bValid = tokenService.validate(userId, token);

        if (!bValid) {
            return new VdResult("OK", VdResult.AUTH_FAILED, null);

        } else {
            return new VdResult("OK", VdResult.AUTH_SUCCESS, null);
        }

    }


}
