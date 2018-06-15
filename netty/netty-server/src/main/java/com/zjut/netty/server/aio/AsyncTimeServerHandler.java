package com.zjut.netty.server.aio;

import com.zjut.netty.common.constants.ServerConstants;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author yuanweipeng
 * @date 2017-12-19
 **/
public class AsyncTimeServerHandler extends Thread{

    CountDownLatch latch;

    AsynchronousServerSocketChannel channel;

    public AsyncTimeServerHandler(String host, int port){
        setName("AsyncTimeServer");
        try {
            channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(host, port));
            System.out.println("Timeserver started success.");

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        accept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("Server is interrupted.");
        }
        try {
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void accept(){
        channel.accept(this, new AcceptCompletionHandler());
    }

    public static void main(String[] args) throws Exception {
        AsyncTimeServerHandler serverHandler = new AsyncTimeServerHandler(ServerConstants.LOCAL_HOST, ServerConstants.SERVER_PORT);
        serverHandler.start();
    }
}
