package com.zjut.netty.server.bio.threadpool;

import com.zjut.netty.common.constants.ServerConstants;
import com.zjut.netty.server.base.BaseServer;
import com.zjut.netty.server.bio.thread.SocketHandler;

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

    private ExecutorService service = new ThreadPoolExecutor(10,10,0,
            TimeUnit.SECONDS,new LinkedBlockingQueue<>());

    private static final String THREAD_NAME_PREFIX = "TimeServerThread_";

    private volatile boolean isStop = false;

    @Override
    public void server(String host, int port) throws Exception{
        ServerSocket serverSocket = null;
        int threadIndex = 1;
        try {
            serverSocket = new ServerSocket();
            SocketAddress endpoint = new InetSocketAddress(host, port);
            serverSocket.bind(endpoint);
            while (!isStop) {
                Socket socket = serverSocket.accept();
                service.submit(new SocketHandler(socket, THREAD_NAME_PREFIX + threadIndex++));
            }
        } finally {
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
