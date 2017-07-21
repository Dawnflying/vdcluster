package com.xh.vdcluster.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by bloom on 2017/7/20.
 */
public class MessageClient {

    private String userName;

    private String password;

    private String hostName;

    private Integer port;

    private String virtualHost;

    private ConnectionFactory connectionFactory;

    private String amqpUrl;

    private static MessageClient client;

    public static MessageClient getInstance() {
        if (client == null)
            client = new MessageClient();

        return client;
    }

    private MessageClient() {
        try {
            connectionFactory.setUri(buildAMQPUrl());
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();

        } catch (Exception e) {

        }
    }

    private String buildAMQPUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append("amqp://").append(userName).append(":").append(password).append("@").append(hostName + ":" + port + "/" + virtualHost);
        return builder.toString();
    }
}
