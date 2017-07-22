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

    private Channel channel;

    private static final String exchangeName = "exchange";

    private static final String queueName = "queue";

    private static final String routingKey = "vd.device";

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
            channel = connection.createChannel();

            channel.exchangeDeclare(exchangeName, "direct", true);
            channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, exchangeName, routingKey);


        } catch (Exception e) {

        }
    }

    private String buildAMQPUrl() {
        StringBuilder builder = new StringBuilder();
        builder.append("amqp://").append(userName).append(":").append(password).append("@").append(hostName + ":" + port + "/" + virtualHost);
        this.amqpUrl = builder.toString();
        return amqpUrl;
    }

    private void publishMessage(String message) throws Exception{
        byte[] messageBodyBytes = message.getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
    }


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
}
