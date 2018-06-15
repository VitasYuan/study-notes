package com.zjut.netty.server.netty;

import com.zjut.netty.common.constants.ServerConstants;
import com.zjut.netty.common.util.DateUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;


/**
 * @author yuanweipeng
 * @date 2017-12-21
 **/
public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buffer = (ByteBuf) msg;
        byte[] request = new byte[buffer.readableBytes()];
        buffer.readBytes(request);
        String body = new String(request, "UTF-8");
        System.out.println("TimeServer get request:" + body);
        String response = ServerConstants.INTERFACE_URL.equals(body) ? "Current time is: " + DateUtil.format(new Date()) :
                "Error order.";
        ByteBuf writeBuf = Unpooled.copiedBuffer(response.getBytes());
        ctx.write(writeBuf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
