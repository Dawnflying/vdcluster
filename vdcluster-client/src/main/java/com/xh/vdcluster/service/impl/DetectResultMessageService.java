package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.AvatarMQ.MessageAdapter;
import com.xh.vdcluster.rpc.DetectResult;
import com.xh.vdcluster.service.MessageService;

import javax.annotation.Resource;

/**
 * Created by bloom on 2017/7/20.
 */
public class DetectResultMessageService implements MessageService {

    private String topic;

    @Resource
    private MessageAdapter messageAdapter;

    @Override
    public void pushMessage(Object msg) throws Exception {
        messageAdapter.publishMessage(msg.toString());
    }
}
