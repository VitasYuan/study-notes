package com.zjut.netty.server.nio;

import com.zjut.netty.common.constants.ServerConstants;
import com.zjut.netty.common.util.DateUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @author yuanweipeng
 * @date 2017-12-19
 **/
public class MultiplexerTimeServer implements Runnable {

    private volatile boolean isStop = false;

    private Selector selector;

    private ServerSocketChannel server;

    public MultiplexerTimeServer(String host, int port){
        try {
            //创建server，用于监听指定host的端口
            server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(host, port));
            server.configureBlocking(false);

            selector = Selector.open();
            SelectionKey key = server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("MultiplexerTimeServer started success.");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    @Override
    public void run() {
        while (!isStop) {
            try {
                int readyCount = selector.select(1000);
                selector.keys();
                if (readyCount > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    System.out.println("selectionKeys size:" + selectionKeys.size());
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    SelectionKey key = null;
                    while (iterator.hasNext()) {
                        key = iterator.next();
                        iterator.remove();
                        try {
                            handleInput(key);
                        } catch (Exception e) {
                            if (key != null) {
                                key.cancel();
                                if (key.channel() != null) {
                                    key.channel().close();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws Exception {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                SocketChannel channel = serverChannel.accept();
                channel.configureBlocking(false);
                channel.register(selector, SelectionKey.OP_READ);
            }

            if (key.isReadable()) {
                SocketChannel channel = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                CharBuffer charBuffer = CharBuffer.allocate(10);
                char[] chars = new char[20];
                readBuffer.mark();
                int readCount = channel.read(readBuffer);
                if (readCount > 0) {

                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String request = new String(bytes, "UTF-8");
                    System.out.println("TimeServer get request:" + request);
                    String response = ServerConstants.INTERFACE_URL.equals(request) ? "Current time is: " + DateUtil.format(new Date()):
                            "Error order.";
                    write(channel, response);
                } else if (readCount < 0){
                    key.cancel();
                    channel.close();
                }
            }
        }
    }

    private void write(SocketChannel channel, String response) throws Exception {
        if (response != null && response.length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }

    public static void main(String[] args) throws Exception {
        MultiplexerTimeServer server = new MultiplexerTimeServer(ServerConstants.LOCAL_HOST, ServerConstants.SERVER_PORT);
        new Thread(server).start();
    }
}
