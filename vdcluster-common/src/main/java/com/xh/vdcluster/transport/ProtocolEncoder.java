package com.xh.vdcluster.transport;

import com.xh.vdcluster.transport.model.Frame;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by bloom on 2017/7/25.
 */
public class ProtocolEncoder extends MessageToByteEncoder<Frame> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Frame frame, ByteBuf byteBuf) throws Exception {

    }
}
