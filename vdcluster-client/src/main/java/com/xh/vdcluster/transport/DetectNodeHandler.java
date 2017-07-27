package com.xh.vdcluster.transport;

import com.xh.vdcluster.transport.model.Frame;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by bloom on 2017/7/27.
 */
public class DetectNodeHandler extends SimpleChannelInboundHandler<Frame> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Frame frame) throws Exception {



    }
}
