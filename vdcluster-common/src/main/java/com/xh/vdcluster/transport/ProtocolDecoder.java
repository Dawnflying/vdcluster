package com.xh.vdcluster.transport;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetSocketAddress;
import java.util.List;

/**
 * Created by bloom on 2017/7/25.
 */
public class ProtocolDecoder extends ByteToMessageDecoder{
    private  static Logger logger = LoggerFactory.getLogger(ProtocolDecoder.class);

    private byte[] inputData;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        InetSocketAddress nodeAddress = ((InetSocketAddress)channelHandlerContext.channel().remoteAddress());

        String nodeIP = nodeAddress.getAddress().getHostAddress();

        int nodePort = nodeAddress.getPort();

        logger.info("got message from {}:{}",nodeIP,nodePort);

        inputData = new byte[byteBuf.readableBytes()];

        if(byteBuf.readableBytes()>0)
            byteBuf.readBytes(inputData,0,byteBuf.readableBytes());



    }
}
