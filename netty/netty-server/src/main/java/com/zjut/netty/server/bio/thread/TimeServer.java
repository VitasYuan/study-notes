package com.zjut.netty.server.bio.thread;

import com.zjut.netty.common.constants.ServerConstants;
import com.zjut.netty.server.base.BaseServer;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.*;

/**
 * @author yuanweipeng
 * @date 2017-12-13
 **/
public class TimeServer implements BaseServer {

    private static final String THREAD_NAME_PREFIX = "TimeServerThread_";

    private volatile boolean isStop = false;


    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);


    @Override
    public void server(String host, int port) throws Exception{
        ServerSocket serverSocket = null;
        int threadIndex = 1;
        long startTime = System.currentTimeMillis();
        executorService.schedule()
        try {
            //TODO backlog test
            serverSocket = new ServerSocket();
//            serverSocket.setSoTimeout(1000 * 5);
            SocketAddress endpoint = new InetSocketAddress(host, port);
//            ServerSocket.setSocketFactory();
            serverSocket.bind(endpoint,1023);
            while (!isStop) {

                Socket socket = serverSocket.accept();

                executorService.execute(new SocketHandler(socket, THREAD_NAME_PREFIX + threadIndex++));
            }
        } finally {
            System.out.println("服务关闭.accept 时间：" + (System.currentTimeMillis() - startTime));

            if (serverSocket != null) {
                serverSocket.close();
                System.out.printf("Server closed.");
            }

        }
    }

    @Override
    public void stopServer() {
        this.isStop = true;
    }

    public static void main(String[] args) throws Exception {
        TimeServer timeServer = new TimeServer();
        timeServer.server(ServerConstants.LOCAL_HOST, ServerConstants.SERVER_PORT);
    }

}
