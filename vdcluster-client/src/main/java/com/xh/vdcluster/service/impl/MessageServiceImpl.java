package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.messagequeue.MessageManager;
import com.xh.vdcluster.rpc.DetectResult;
import com.xh.vdcluster.service.MessageService;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

/**
 * Created by bloom on 2017/7/20.
 */
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageManager messageManager;

    @Override
    public void pushMessage(String topic, Object msg) throws Exception {
        String message = msg.toString();
        messageManager.publishMessage(message);
    }

    @Override
    public void subscribe(String topic, Callable<Object> callable) throws Exception {

    }
}
