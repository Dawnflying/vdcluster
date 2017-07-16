package com.xh.videodetect.controller;

import com.xh.videodetect.model.VdResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by bloom on 2017/7/16.
 */

@RestController
public class ConsumerController  {

    @RequestMapping("/login")
    public VdResult login(@RequestParam(name = "username")String username,@RequestParam(name="code")String code){


    }
}
