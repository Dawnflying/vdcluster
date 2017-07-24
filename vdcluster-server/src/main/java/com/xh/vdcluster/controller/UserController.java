package com.xh.vdcluster.controller;

import com.xh.vdcluster.common.VdResult;
import com.xh.vdcluster.service.UserService;
import com.xh.vdcluster.service.VdService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * Created by bloom on 2017/7/16.
 */

@RestController
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/request-token")
    public VdResult request(@RequestParam(name = "username") String username, @RequestParam(name = "code") String code) {

        return userService.requestToken(username,code);
    }
}
