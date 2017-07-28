package com.xh.vdcluster.transport;

import com.sun.security.ntlm.Server;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by bloom on 2017/7/25.
 */
public class NettyClient {

    private static EventLoopGroup workerGroup = new NioEventLoopGroup();

    private String clusterServerHost;

    private int clusterServerPort;


    public NettyClient(){

        try{

            Bootstrap b = new Bootstrap();

            b.group(workerGroup).channel(NioSocketChannel.class).handler(new DetectNodeInitializer());

            ChannelFuture f = b.connect(clusterServerHost, clusterServerPort).sync();

            f.channel().close();

        }
        catch (Exception e){

        }
        finally {
            workerGroup.shutdownGracefully();
        }

    }

}
