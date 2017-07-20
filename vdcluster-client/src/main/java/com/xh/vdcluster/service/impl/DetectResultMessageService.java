package com.xh.vdcluster.service.impl;

import com.rabbitmq.client.ConnectionFactory;
import com.xh.vdcluster.model.DetectResult;
import com.xh.vdcluster.service.MessageService;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

/**
 * Created by bloom on 2017/7/20.
 */
public class DetectResultMessageService implements MessageService<DetectResult> {
    @Override
    public void pushMessage(DetectResult msg) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(userName);
        factory.setPassword(password);
        factory.setVirtualHost(virtualHost);
        factory.setHost(hostName);
        factory.setPort(portNumber);
        Connection conn = factory.newConnection();
    }
}
