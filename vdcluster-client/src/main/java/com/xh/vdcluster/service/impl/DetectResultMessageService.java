package com.xh.vdcluster.service.impl;

import com.xh.vdcluster.client.MessageManager;
import com.xh.vdcluster.rpc.DetectResult;
import com.xh.vdcluster.service.MessageService;

/**
 * Created by bloom on 2017/7/20.
 */
public class DetectResultMessageService implements MessageService<DetectResult> {

    private String topic;

    @Override
    public void pushMessage(DetectResult msg) throws Exception {
        String message = msg.toString();
        MessageManager.getInstance().publishMessage(message);
    }
}
