package com.xh.vdcluster.messagequeue;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by bloom on 2017/7/20.
 */
public class MessageManager {

    /**
     * 用户名
     */
    private String userName;

    private String password;

    private String hostName;

    private Integer port;

    private String virtualHost;

    private ConnectionFactory connectionFactory;

    private Channel channel;

    /**
     * amqp URL地址
     */
    private String amqpUrl;

    /**
     * exchange 名称
     */
    private String exchangeName;

    /**
     * 路由键
     */
    private String routingKey;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }

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
