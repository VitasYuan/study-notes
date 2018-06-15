package com.zjut.netty.server.aio;

import com.zjut.netty.common.constants.ServerConstants;
import com.zjut.netty.common.util.DateUtil;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * @author yuanweipeng
 * @date 2017-12-20
 **/
public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel socketChannel;

    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        this.socketChannel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        System.out.println("ReadCompletionHandler threadName:" + Thread.currentThread().getName());

        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String request = new String(body, "UTF-8");
            String response = ServerConstants.INTERFACE_URL.equals(body) ? "Current time is: " + DateUtil.format(new Date()) :
                    "Error order.";
            write(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.socketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void write(String response){
        if (response != null && response.length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            socketChannel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("WriteCompletionHandler threadName:" + Thread.currentThread().getName());
                    if (attachment.hasRemaining()) {
                        socketChannel.write(attachment, attachment, this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        socketChannel.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
