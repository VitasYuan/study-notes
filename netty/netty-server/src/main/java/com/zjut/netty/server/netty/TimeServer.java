package com.zjut.netty.server.netty;

import com.zjut.netty.common.constants.ServerConstants;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author yuanweipeng
 * @date 2017-12-21
 **/
public class TimeServer {

    public void bind(String host, int port) throws Exception{
        //线程组，分别用于管理连接和网络IO
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024).childHandler(new ChildChannelHandler());
            //绑定端口，sync()等待绑定端口成功后返回ChannelFuture，类似于Futur，主要用于异步操作的回调
            ChannelFuture future = server.bind(new InetSocketAddress(host, port)).sync();

            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        TimeServer timeServer = new TimeServer();
        timeServer.bind(ServerConstants.LOCAL_HOST, ServerConstants.SERVER_PORT);
    }
}
