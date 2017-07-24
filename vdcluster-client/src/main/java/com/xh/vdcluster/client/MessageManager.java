package com.xh.vdcluster.client;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by bloom on 2017/7/20.
 */
public class MessageManager {

    private String userName;

    private String password;

    private String hostName;

    private Integer port;

    private String virtualHost;

    private ConnectionFactory connectionFactory;

    private Channel channel;

    private String amqpUrl;

    /**
     * exchange 名称
     */
    private String exchangeName;

    /**
     * 路由键
     */
    private String routingKey;

    private static MessageManager client;

    public static MessageManager getInstance() {
        if (client == null)
            client = new MessageManager();

        return client;
    }

    private MessageManager() {
        try {
            connectionFactory = new ConnectionFactory();
            connectionFactory.setUri(buildAMQPUrl());
            Connection connection = connectionFactory.newConnection();
            this.channel = connection.createChannel();

        } catch (Exception e) {

        }
    }

    private String buildAMQPUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append("amqp://").append(userName).append(":").append(password).append("@").append(hostName + ":" + port + "/" + virtualHost);
        return builder.toString();
    }


    public void publishMessage(String message) throws IOException {
        byte[] messageBodyBytes = message.getBytes();
        channel.basicPublish(exchangeName, routingKey,
                new AMQP.BasicProperties.Builder()
                        .contentType("text/plain")
                        .deliveryMode(2)
                        .priority(1)
                        .userId("bob")
                        .build(),
                messageBodyBytes);
    }
}
