package com.xh.vdcluster.controller;

import com.xh.vdcluster.authenication.TokenFactory;
import com.xh.vdcluster.model.VdResult;
import com.xh.vdcluster.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by bloom on 2017/7/16.
 */

@RestController
public class ConsumerController {

    @Resource
    UserService userService;

    @RequestMapping("/authenticate")
    public VdResult authenticate(@RequestParam(name = "username") String username, @RequestParam(name = "code") String code) {

        if (userService.authenticate(username, code)) {
            return new VdResult("OK",VdResult.AUTH_SUCCESS,TokenFactory.getToken());
        } else {
            return new VdResult("OK",VdResult.AUTH_SUCCESS,null);
        }

    }
}
